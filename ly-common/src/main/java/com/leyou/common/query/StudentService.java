package com.leyou.common.query;

import com.leyou.common.pojo.Student;
import com.leyou.common.query.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lq on 2019/9/6.
 */
@Service
public class StudentService extends BaseServiceImpl<Student,Long> implements IStudentService<Student, Long> {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public BaseRepository<Student> repository() {
        return studentRepository;
    }
}
