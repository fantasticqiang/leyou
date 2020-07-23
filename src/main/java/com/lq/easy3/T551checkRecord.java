package com.lq.easy3;

/**
 * @author lq
 * @date 2020-07-03 09:48
 */
public class T551checkRecord {

    /**
     * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
     *
     * 'A' : Absent，缺勤
     * 'L' : Late，迟到
     * 'P' : Present，到场
     * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
     *
     * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
     * @param args
     */
    public static void main(String[] args) {
        boolean r = checkRecord("PPALLP");
        System.out.println(r);
        boolean r2 = checkRecord("PPALLL");
        System.out.println(r2);
        boolean r3 = checkRecord("LALL");
        System.out.println(r3);


        String b = "1,2,3,,,4,,5";
        b = b.replaceAll(",+", ",");
        System.out.println(b);
    }

    public static boolean checkRecord(String s) {
        int aCount = 0; //缺勤次数
        int lCount = 0; //连续迟到次数
        char[] chars = s.toCharArray();
        for (char c : chars) {
            //缺勤
            if (c == 'A') {
                aCount++;
                if (aCount == 2) { //缺勤两次 return false
                    return false;
                }
            } else if (c == 'L') {
                // 迟到
                lCount++;
                if (lCount == 3) { //连续迟到3次
                    return false;
                }
                continue; //迟到的话读下一个
            }
            // 不为迟到 连续迟到次数清零
            lCount = 0;
        }
        return true;
    }
}
