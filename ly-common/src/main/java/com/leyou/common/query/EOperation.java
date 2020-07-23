package com.leyou.common.query;

/**
 * Created by lq on 2019/9/3.
 */
public enum EOperation {

    equal("="),

    like("like")
    ;
    String value;

    EOperation(String value) {
        this.value = value;
    }
}
