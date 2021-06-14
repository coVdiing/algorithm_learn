package com.vi.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: vi
 * @Date: 2021-05-22 12:08
 * @Version: 1.0
 * @Description:
 */
public class LeetCode3 {
    public static void main(String[] args) {
        String s = "";
        int result = new LeetCode3().lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {

        StringBuilder sb = new StringBuilder();
        int index = 1;
        int flag = 0;
        sb.append(s.charAt(0));
        int max = 0;
        while (index < s.length()) {
            char current = s.charAt(index);
            if (!sb.toString().contains(String.valueOf(current))) {
                // 不包含就存入set中
                sb.append(current);
            } else {
                // 比较max和当前不重复子串的长度
                if (max < (index - flag)) {
                    max = index - flag;
                }
                // flag移到重复字符的下一位
                flag=flag+sb.toString().indexOf(current)+1;
                // 删除flag之前的子串
                sb = new StringBuilder();
                sb.append(s.substring(flag, index + 1));
            }
            index++;
        }
        return Math.max(max, index - flag);
    }
}
