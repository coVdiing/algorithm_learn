package com.vi.hw;

import java.util.Scanner;

/**
 * @Author: vi
 * @Date: 2021-08-02 22:31
 * @Version: 1.0
 * @Description:
 */
public class HJ7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String param = sc.nextLine();
        String[] arr = param.split("\\.");
        if(arr.length > 1) {
            int result = Integer.parseInt(arr[0]);
            int data = Integer.parseInt(arr[1].substring(0,1));
            if(data >= 5) {
                result++;
            } else {
                result--;
            }
            System.out.println(result);
        } else {
            System.out.println(arr[0]);
        }

    }
}
