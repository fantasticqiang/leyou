package com.leyou.common.query;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by lq on 2019/9/3.
 */
@Data
@NoArgsConstructor
public class QueryEntityBean<T> implements Specification<T> {

    private List<FieldOperationValue> andQueryList;

    private List<FieldOperationValue> orQueryList;

    private List<FieldOperationValue> ascList;

    private Integer totalCount;

    private Integer currentPage;

    private Integer pageCount;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        Predicate restrictions = cb.and(getAndPredicate(root, cb));
        return restrictions;
    }

    //and 谓语
    private Predicate getAndPredicate(Root<T> root, CriteriaBuilder cb) {
        Predicate restrictions = cb.conjunction();
        for(FieldOperationValue condition : andQueryList) {
            if (condition == null) continue;
            Path<?> path = this.getPath(root, condition.getName());
            if(path == null) continue;
            switch (condition.getOperation()) {
                case equal:
                    if(condition.getValue() != null) {
                        if(String.class.isAssignableFrom(path.getJavaType())
                                && condition.value instanceof String) {
                            if(StringUtils.isNotBlank(condition.value)) {
                                restrictions = cb.and(restrictions, cb.equal(path, condition.value));
                            }
                        } else {
                            restrictions = cb.and(restrictions, cb.equal(path, condition.value));
                        }
                    }
                    break;
            }
        }
        return restrictions;
    }

    private Predicate getOrPredicate(Root<T> root, CriteriaBuilder cb) {

        return null;
    }

    private <X> Path<X> getPath(Path<?> path, String propertyPath) {
        if(path == null || StringUtils.isEmpty(propertyPath)) {
            return (Path<X>) path;
        }
        String property = StringUtils.substringBefore(propertyPath, ".");
        return getPath(path.get(property), StringUtils.substringAfter(propertyPath, "."));
    }
}

