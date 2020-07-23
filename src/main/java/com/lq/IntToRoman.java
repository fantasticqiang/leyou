package com.lq;

import com.sun.xml.internal.ws.server.EndpointMessageContextImpl;

import java.util.*;

/**
 * Created by lq on 2020/2/12.
 */
public class IntToRoman {

    public static void main(String[] args) {
//        String s = intToRoman(1994);
//        System.out.println(s);
//        System.out.println(intToRoman(58));
//        System.out.println(intToRoman(9));
//        System.out.println(intToRoman(4));
//        System.out.println(intToRoman(3));


        //求公共最长前缀
/*        String[] strs = {"flower","flow","flight"};
        String s = longestCommonPrefix2(strs);
        System.out.println(s);
        String[] strs1 = {"c", "acc", "ccc"};
        System.out.println(longestCommonPrefix2(strs1));
          String[] strs2 = {"c", "c"};
          System.out.println(longestCommonPrefix2(strs2));
        String[] strs3 = {"aaa", "aa", "aaa"};
        System.out.println(longestCommonPrefix2(strs3));
        String[] strs4 = {"aaaa", "aaac", "aaab"};
        System.out.println(longestCommonPrefix2(strs4));*/

        //三数之和
/*        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 0};
        int[] nums3 = {0, 0, 0};
        int[] nums4 = {0, 0, 0, 0};
        int[] nums5 = {-1, 0, 1, 0};
        int[] nums6 = {-2, 0, 1, 1, 1, 2};
        int[] nums7 = {-2, 0, 0,2, 2};
        int[] nums8 = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        int[] nums9 = {-1, -1, 0, 1};
        int[] nums10 = {-2, -1, 0, 1, 2, 3};
        int[] nums11 = {-4,-4,-4,-4,-3,-3,-2,-1,0,2,2,2,3,3};
        int[] nums12 = {-5, -5, -4, -4, -4, -2, -2, -2, 0, 0, 0, 1, 1, 3, 4, 4};
        List<List<Integer>> lists = threeSum(nums12);
        for(List<Integer> item : lists) {
            System.out.println(Arrays.toString(item.toArray()));
        }*/

        //求电话号码字符组合
        letterCombinations("23");
    }


    public static String intToRoman(int num) {

        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();
        int index = 0;
        while (num > 0) {
            if(num >= nums[index]) {
                num -= nums[index];
                result.append(romans[index]);
            } else {
                index++;
            }
        }

        return result.toString();
    }

    public static int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;

    }

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    /**
     * 字符串最长公共子串
     */
    public static String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0) {
            return "";
        }
        int index = 0;
        String finalStr = strs[0];
        if("".equals(finalStr)) {
            return "";
        }
        for(int i = 0; i < strs.length; i++) {
            if(index < strs[i].length() && finalStr.charAt(index) == strs[i].charAt(index)){

                if(i == strs.length - 1) {
                   index++;
                   i = -1;
                }
            } else {
                break;
            }
        }
        return finalStr.substring(0, index);
    }

    public static String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        //求strs中最短的str
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());

        //二分法
        int right = minLen;
        int low = 1;
        while (low <= right) {
            int middle = (low + right) / 2;
            if (getIndex(strs, middle)) {
                low = middle + 1;
            } else {
                right = middle - 1;
            }

        }
        return strs[0].substring(0, (low + right) / 2);
    }

    private static boolean getIndex(String[] strs, int right) {
        String tmpStr = null;
        for(String str : strs) {
            if(tmpStr == null) {
               tmpStr = str.substring(0, right);
               continue;
            }
            if(!tmpStr.substring(0,right).equals(str.substring(0, right))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 求数组中三个数相加是0
     * nums = {-4, -1, -1, 0, 1, 2}
     * {-4, -1, -1, 0, 1, 2}
     * {-1, 0, 0, 1}
     * {-2, 0, 1,1, 1, 2}
     * {-2, 0, 0,2, 2}
     * {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}
     * {3,0,-2,-1,1,2}
     * {-2, -1, 0, 1, 2, 3}
     * {-4,-1,-4,0,2,-2,-4,-3,2,-3,2,3,3,-4}
     * {-4,-4,-4,-4,-3,-3,-2,-1,0,2,2,2,3,3}
     * {-5, -5, -4, -4, -4, -2, -2, -2, 0, 0, 0, 1, 1, 3, 4, 4}
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;

    }

    public static int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if(Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    R--;
                } else if(sum < target) {
                    L++;
                } else {
                    return res;
                }
            }
        }
        return res;
    }


    /**
     * 电话号码的字母组合
     */
    public static List<String> letterCombinations(String digits) {
        /*ArrayList<String> result = new ArrayList<>();
        int length = digits.length();
        for(int i = -1; i < length; i++) {
            String currentLetter = i == -1 ? "" : digits.charAt(i) + "";
            String nextLetter = i == length - 1 ? "" : digits.charAt(i + 1) + "";
            forEach(currentLetter, nextLetter, result);
        }
        return result;*/
        if("".equals(digits)) {
            return resultList;
        }
/*        forEach2(0, digits, "");*/
        forEach3("", digits);
        resultList.stream().forEach(System.out::println);
        return resultList;
    }

    private static Map<String, String[]> lettersMap = new HashMap<String, String[]>() {
        {
            put("2", new String[]{"a", "b", "c"});
            put("3", new String[]{"d", "e", "f"});
            put("4", new String[]{"g", "h", "i"});
            put("5", new String[]{"j", "k", "l"});
            put("6", new String[]{"m", "n", "o"});
            put("7", new String[]{"p", "q", "r", "s"});
            put("8", new String[]{"t", "u", "v"});
            put("9", new String[]{"w", "x", "y", "z"});

        }
    };


    private static void forEach(String currentLetter, String nextLetter, List<String> result) {
        if(currentLetter.equals("") && !nextLetter.equals("")) {
            String[] nextStringArray = lettersMap.get(nextLetter);
            for(String tmpStr : nextStringArray) {
                result.add(tmpStr);
            }
        } else if(!currentLetter.equals("") && !nextLetter.equals("")) {
            String[] nextStringArray = lettersMap.get(nextLetter);
            ArrayList<String> result2 = new ArrayList<>();
            for(String tmpStr : result) {
                for(String tmpStr2 : nextStringArray) {
                    result2.add(tmpStr + tmpStr2);
                }
            }
            result.clear();
            result.addAll(result2);
        }
    }

    private static List<String> resultList = new ArrayList<>();

    private static void forEach2(int index, String digits, String curr) {
        String[] strings = lettersMap.get(digits.charAt(index) + "");
        if(index < digits.length() - 1) {
            for(String tmp : strings) {
                forEach2(index + 1, digits, curr + tmp);
            }
        } else {
            for(String tmp : strings) {
                resultList.add(curr + tmp);
            }
        }
    }

    private static void forEach3(String combination, String digits) {
        if(digits.length() == 0) {
            resultList.add(combination);
        } else {
            String[] strings = lettersMap.get(digits.substring(0, 1));
            for(String letter : strings) {
                forEach3(combination + letter, digits.substring(1));
            }
        }
    }


}
