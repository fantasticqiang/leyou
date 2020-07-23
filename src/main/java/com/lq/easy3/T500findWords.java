package com.lq.easy3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author lq
 * @date 2020-06-27 17:35
 */
public class T500findWords {

    /**
     * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示
     * @param args
     */
    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] r = findWords(words);
        System.out.println(String.join(",", r));

        String[] r2 = findWords2(words);
        System.out.println(String.join(",", r2));
    }

    public static String[] findWords(String[] words) {
        List<HashSet<Character>> keyBoard = new ArrayList<>();
        keyBoard.add(new HashSet<Character>(){{
            char[] chars = "qwertyuiop".toCharArray();
            for (char c : chars) {
                add(c);
            }
        }});
        keyBoard.add(new HashSet<Character>(){{
            char[] chars = "asdfghjkl".toCharArray();
            for (char c : chars) {
                add(c);
            }
        }});
        keyBoard.add(new HashSet<Character>(){{
            char[] chars = "zxcvbnm".toCharArray();
            for (char c : chars) {
                add(c);
            }
        }});
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            String tmp = word.toLowerCase();
            int row = 0;
            if (keyBoard.get(0).contains(tmp.charAt(0))) {
                row = 0;
            } else if (keyBoard.get(1).contains(tmp.charAt(0))) {
                row = 1;
            } else if (keyBoard.get(2).contains(tmp.charAt(0))) {
                row = 2;
            }
            HashSet<Character> set = keyBoard.get(row);
            char[] wordArray = tmp.toCharArray();
            boolean flag = true;
            for (char w : wordArray) {
                if (!set.contains(w)) {
                    flag = false;
                    break;
                }
            }
            if(flag == true) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static String[] findWords2(String[] words) {
        String[] keyBoard = {"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            String tmp = "";
            if (keyBoard[0].indexOf(word.charAt(0)) != -1) {
                tmp = keyBoard[0];
            } else if (keyBoard[1].indexOf(word.charAt(0)) != -1) {
                tmp = keyBoard[1];
            } else if (keyBoard[2].indexOf(word.charAt(0)) != -1) {
                tmp = keyBoard[2];
            }
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (tmp.indexOf(word.charAt(i)) == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }

}
