package com.leyou.common.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by lq on 2019/9/3.
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaSpecificationExecutor<T>, JpaRepository<T, Long> {


}
