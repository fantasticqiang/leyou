import com.fasterxml.jackson.databind.ObjectMapper;
import com.leyou.common.pojo.Student;
import com.leyou.common.query.EOperation;
import com.leyou.common.query.FieldOperationValue;
import com.leyou.common.query.QueryEntityBean;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lq on 2019/9/4.
 */
public class NewQueryJson {

    public static void main(String[] args) throws Exception {
        List<FieldOperationValue> list = new ArrayList<>();
        FieldOperationValue s1 = new FieldOperationValue("age", EOperation.equal, "18");
        list.add(s1);

        QueryEntityBean result = new QueryEntityBean();
        result.setAndQueryList(list);
        System.out.println(URLEncoder.encode(new ObjectMapper().writeValueAsString(result), "utf-8"));
    }
}
