package com.lq.easy;

import java.util.Arrays;

/**
 * Created by lq on 2020/5/12.
 */
public class T9plusOne {

    public static void main(String[] args) {
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        int[] result = plusOne(digits);
        Arrays.stream(result).forEach(System.out::println);
    }

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

     最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

     你可以假设除了整数 0 之外，这个整数不会以零开头。

     示例 1:

     输入: [1,2,3]
     输出: [1,2,4]
     解释: 输入数组表示数字 123。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/plus-one
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int[] plusOne(int[] digits) {
        int[] tmp;
        tmp = new int[digits.length + 1];
        System.arraycopy(digits, 0, tmp, 1, digits.length);
        plusOne(tmp, tmp.length - 1);
        if(tmp[0] == 0) {
            int[] tmp2 = new int[tmp.length - 1];
            System.arraycopy(tmp, 1, tmp2, 0, tmp2.length);
            return tmp2;
        }
        return tmp;
    }

    private static void plusOne(int[] digits, int index) {
        if(digits[index] <= 8) {
            digits[index] = digits[index] + 1;
            return;
        }
        digits[index] = 0;
        if(index >= 1) {
            plusOne(digits, index - 1 );
        }
    }
}
