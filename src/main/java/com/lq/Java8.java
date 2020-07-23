package com.lq;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lq
 * @date 2020-06-11 20:58
 */
public class Java8 {

    public static void main(String[] args) {
        mySort();
    }

    public static void mySort() {
        List<Status> collect = Arrays.stream(Status.values()).sorted(Comparator.comparing(Status::getOrder).reversed()).collect(Collectors.toList());
        collect.stream().forEach(x -> {
            System.out.println(x.name());
        });
    }

    enum Status {
        status3 {
            @Override
            public int getOrder() {
                return 3;
            }
        },
        status1 {
            @Override
            public int getOrder() {
                return 1;
            }
        },
        status2 {
            @Override
            public int getOrder() {
                return 2;
            }
        },


        ;

        public abstract int getOrder();

    }
}
