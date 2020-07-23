package com.leyou.common.query;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by lq on 2019/9/3.
 * @Query 标签的参数解析
 */
public class QueryParameterResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if(parameter.hasParameterAnnotation(Search.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        Search parameterAnnotation = methodParameter.getParameterAnnotation(Search.class);
        String queryJsonStr = nativeWebRequest.getParameter(parameterAnnotation.value());
        QueryEntityBean queryEntityBean = new ObjectMapper().readValue(queryJsonStr, QueryEntityBean.class);
        return queryEntityBean;
    }
}
