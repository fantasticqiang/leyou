package com.leyou.common.query;

import java.lang.annotation.*;

/**
 * Created by lq on 2019/9/3.
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Search {
    String value() default "query";
}
