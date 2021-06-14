package com.vi.algorithm.leetcode;

import java.util.ArrayList;

/**
 * @Author: vi
 * @Date: 2021-05-24 21:44
 * @Version: 1.0
 * @Description:
 */
public class LeetCode6 {
    public static void main(String[] args) {
        LeetCode6 lc = new LeetCode6();
        String s = "PAYPALISHIRING";
        String convert = lc.convert(s, 3);
        System.out.println(convert);

    }

    public String convert(String s, int numRows) {
        if (numRows == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        // 记录数组的下标
        int[] indexArr = new int[numRows];
        int col =s.length()/numRows+s.length()%numRows+1;
        ArrayList<char[]> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new char[col]);
        }

        int y = 0;
        int flag = -1;
        int index = 0;
        while( index < s.length()) {
            if (y == 0) {
                flag = 1;
            }
            if (y == numRows - 1) {
                flag = -1;
            }
            char[] chars = list.get(y);
            chars[indexArr[y]] = s.charAt(index++);
            indexArr[y] = indexArr[y]+1;
            y += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (char[] c : list) {
            sb.append(c);
        }
        return sb.toString().replaceAll("","\u0000");
    }


}
