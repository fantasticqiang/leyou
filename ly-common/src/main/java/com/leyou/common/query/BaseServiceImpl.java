package com.leyou.common.query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by lq on 2019/9/6.
 */
@Service
public abstract class BaseServiceImpl<T, ID> implements IBaseService<T, ID> {

    private Class<T> entityClass;

    public BaseServiceImpl() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        entityClass = (Class) pt.getActualTypeArguments()[0];
    }
    
    public abstract BaseRepository<T> repository();


    @Override
    public List<T> findAll(Specification spe) {
        return repository().findAll(spe);
    }
}
