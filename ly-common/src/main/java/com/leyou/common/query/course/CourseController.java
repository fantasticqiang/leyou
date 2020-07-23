package com.leyou.common.query.course;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leyou.common.pojo.Course;
import com.leyou.common.query.QueryEntityBean;
import com.leyou.common.query.QueryParameterResolver;
import com.leyou.common.query.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by lq on 2019/9/6.
 */
@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @RequestMapping("query")
    public String query(@Search QueryEntityBean query) throws Exception {
        Specification<Course> specification = new Specification<Course>() {
            @Override
            public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate teacher1 =  criteriaBuilder.or(
                        criteriaBuilder.equal(root.get("teacher"), "zhangsan"),
                        criteriaBuilder.equal(root.get("teacher"), "李四"));
                return criteriaQuery.where(teacher1).getRestriction();
            }
        };

        List<Course> all = courseService.findAll(specification);
        return new ObjectMapper().writeValueAsString(all);
    }
}
