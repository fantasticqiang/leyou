package com.leyou.common.query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leyou.common.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lq on 2019/9/3.
 */
@RestController
@RequestMapping("student")
public class Controller {

    @PersistenceContext
    private EntityManager em;


    @Autowired
    private StudentService studentService;

    @RequestMapping("query")
    public String query(@Search QueryEntityBean queryEntityBean) throws Exception {
        List<Student> all = studentService.findAll(queryEntityBean);
        return new ObjectMapper().writeValueAsString(all);
    }

    @RequestMapping("specification")
    public String specification(@RequestParam(name = "name") String name,
                                @RequestParam(name = "age") Integer age) throws Exception {

//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
//        Root<Student> studentRoot = cq.from(Student.class);
//        cq.multiselect(studentRoot.get("id"));
//        cq.multiselect(studentRoot.get("name"));
//        cq.multiselect(studentRoot.get("age"));
//        cq.where(cb.equal(studentRoot.get("name"), name));
//        List<Student> s1 = em.createQuery(cq).getResultList();

        String name1 = "xiaoHong";
        int age1 = 18;
        String name2 = "xiaoMing";
        int age2 = 17;
        ArrayList<Specification> orList = new ArrayList<>();
        Specification<Student> s1 = new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                return criteriaQuery.where(criteriaBuilder.or(
                        criteriaBuilder.equal(root.get("age"), age2),
                        criteriaBuilder.equal(root.get("name"), "ff")
                )).getRestriction();
            }
        };
        Specification<Student> s2 = new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                return criteriaQuery.where(criteriaBuilder.or(
                        criteriaBuilder.equal(root.get("age"), age2),
                        criteriaBuilder.equal(root.get("name"), name2)
                )).getRestriction();
            }
        };

        List<Student> all = studentService.findAll(s1.and(s2));

        return new ObjectMapper().writeValueAsString(all);
    }
}
