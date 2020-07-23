package com.lq.easy2;

import javax.security.auth.callback.CallbackHandler;
import java.util.Stack;

/**
 * @author lq
 * @date 2020-06-16 10:19
 */
public class T443compress {

    /**
     * 给定一组字符，使用原地算法将其压缩。
     *
     * 压缩后的长度必须始终小于或等于原数组长度。
     *
     * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
     *
     * 在完成原地修改输入数组后，返回数组的新长度。
     *
     * 进阶：
     * 你能否仅使用O(1) 空间解决问题？
     * 示例 1：
     *
     * 输入：
     * ["a","a","b","b","c","c","c"]
     *
     * 输出：
     * 返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
     *
     * 说明：
     * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
     * 示例 2：
     *
     * 输入：
     * ["a"]
     *
     * 输出：
     * 返回 1 ，输入数组的前 1 个字符应该是：["a"]
     *
     * 解释：
     * 没有任何字符串被替代。
     * 示例 3：
     *
     * 输入：
     * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     *
     * 输出：
     * 返回 4 ，输入数组的前4个字符应该是：["a","b","1","2"]。
     *
     * 解释：
     * 由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
     * 注意每个数字在数组中都有它自己的位置。
     * @param args
     */
    public static void main(String[] args) {
        char[] chars = {'a','b','b','c','c','d'};
        int r = compress(chars);
        System.out.println(r);
    }

    public static int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int index = 0;
        int j = 1;
        for (int i = 0; j < chars.length; j++) {
            if( chars[i] != chars[j] || j == chars.length - 1) {
                if(chars[i] == chars[j]) {
                    j++;
                }
                chars[index++] =  chars[i];
                if(j - i > 1) {
                    int n = j - i;
                    char[] num = String.valueOf(n).toCharArray();
                    for (char c : num) {
                        chars[index++] = c;
                    }
                }
                i = j;
            }
            if(j == chars.length - 1) {
                chars[index++] = chars[j];
            }
        }
        return index;
    }

    public static int compress2(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
             if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public static int compress3(char[] chars) {
        int x=0;//下个不同字母的坐标
        int n=0;//记录当前字母重复的个数
        for (int i = 0; i < chars.length;i++) {
            char a=chars[i];
            n++;
            if( i+1==chars.length || (a!=chars[i+1])){
                chars[x]=a;
                if(n==1){
                    x=x+1;
                }else {
                    String s=String.valueOf(n);
                    char[] ss=s.toCharArray();
                    for (int k = 0;  k < ss.length; k++) {
                        chars[x+k+1] = ss[k];
                    }
                    x=x+ss.length+1;
                }
                n=0;
            }
        }
        return x;
    }
}
