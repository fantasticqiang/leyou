package com.lq.easy;

/**
 * Created by lq on 2020/5/19.
 */
public class T19isPalindrome {

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(s1);
        System.out.println(result);

        String s2 = "race a car";
        boolean result2 = isPalindrome(s2);
        System.out.println(result2);
    }

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

     说明：本题中，我们将空字符串定义为有效的回文串。

     示例 1:

     输入: "A man, a plan, a canal: Panama"
     输出: true
     示例 2:

     输入: "race a car"
     输出: false

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/valid-palindrome
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    public static boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
