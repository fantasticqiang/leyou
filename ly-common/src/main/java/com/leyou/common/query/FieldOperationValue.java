package com.leyou.common.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by lq on 2019/9/3.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldOperationValue {

    public String name;

    public EOperation operation;

    public String value;
}
