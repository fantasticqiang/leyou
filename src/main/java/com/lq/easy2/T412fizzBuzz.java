package com.lq.easy2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lq
 * @date 2020-06-14 22:27
 */
public class T412fizzBuzz {

    /**
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     *
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     *
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     *
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     * @param args
     */
    public static void main(String[] args) {
        List<String> r = fizzBuzz(15);
        r.stream().forEach(x -> System.out.println(x));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>(){
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if (i % entry.getKey() == 0) {
                    sb.append(entry.getValue());
                }
            }
            if (sb.length() == 0) {
               sb.append(i);
            }
            result.add(sb.toString());
        }
        return result;
    }
}
