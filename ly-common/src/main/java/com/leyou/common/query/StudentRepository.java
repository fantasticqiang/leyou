package com.leyou.common.query;

import com.leyou.common.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by lq on 2019/9/4.
 */
@Repository
public interface StudentRepository extends BaseRepository<Student> {

}
