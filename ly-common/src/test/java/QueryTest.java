import com.fasterxml.jackson.databind.ObjectMapper;
import com.leyou.CommonApplication;
import com.leyou.common.pojo.Student;
import com.leyou.common.query.EOperation;
import com.leyou.common.query.FieldOperationValue;
import com.leyou.common.query.QueryEntityBean;
import com.leyou.common.query.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * Created by lq on 2019/9/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonApplication.class)
public class QueryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student s = new Student();
        s.setAge(17);
        s.setName("xiaoMing");
        studentRepository.save(s);
    }

}
