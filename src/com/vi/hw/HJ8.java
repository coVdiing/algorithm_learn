package com.vi.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: vi
 * @Date: 2021-08-02 23:33
 * @Version: 1.0
 * @Description:
 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String param = sc.nextLine();
        char[] target = param.toCharArray();
        int[] content = new int[10];
        int[] sort = new int[10];
        Arrays.fill(content,-1);
        Arrays.fill(sort,-1);
        int max = 0;
        for(int i = target.length-1;i >=0;i--) {
            int index = Integer.parseInt(target[i]+"");
            if(content[index] == -1) {
                content[index] = index;
                sort[index] = max;
                max++;
            }
        }
        int[] result = new int[max];
        for(int i = 0; i < 10;i++) {
            if(sort[i] != -1) {
                result[sort[i]] = content[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < max;i++) {
            System.out.print(result[i]);
        }
    }
}
