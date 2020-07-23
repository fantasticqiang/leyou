package com.leyou.common.query.course;

import com.leyou.common.pojo.Course;
import com.leyou.common.query.BaseRepository;
import com.leyou.common.query.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lq on 2019/9/6.
 */
@Service("courseService")
public class CourseServiceImpl extends BaseServiceImpl<Course, Long> implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public BaseRepository<Course> repository() {
        return courseRepository;
    }
}
