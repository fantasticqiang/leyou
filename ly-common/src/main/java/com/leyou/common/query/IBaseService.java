package com.leyou.common.query;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Created by lq on 2019/9/6.
 */
public interface IBaseService<T, ID> {
    
    List<T> findAll(Specification spe);
}
