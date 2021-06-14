package com.vi.algorithm.leetcode;

/**
 * @Author: vi
 * @Date: 2021-05-29 13:09
 * @Version: 1.0
 * @Description:
 */
public class LeetCode10 {

    public static boolean isMatch(String s, String p) {
        String pattern = "*";
        String[] split = null;
        if (p.contains("*")) {
             split = p.split("\\*");
        } else if (p.contains(".")) {
            split = p.split(".");
            pattern = ".";
        } else {
            pattern = "c";
        }

        if (split != null) {
            for (String str : split) {
                System.out.println(str);
            }
            if ("*".equals(pattern)) {

            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "mississippi";
        String p =  "mis*is*p*.";
//        String p =  "a";

        isMatch(str, p);
    }
}
