package com.vi.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: vi
 * @Date: 2021-07-31 10:44
 * @Version: 1.0
 * @Description:
 */
public class HJ6 {
    public static void main(String[] args) {
//        long num = 2000000014;
//        List<Long> temp = new ArrayList<>();
//        for (long i = 2; i <= num / 2; i++) {
//            if (num % i == 0) {
//                temp.add(i);
//            }
//        }
//        System.out.println(temp);
        method1();
    }
    public static void method1() {
        Scanner sc = new Scanner(System.in);
        String param = sc.nextLine();
        long target = Long.valueOf(param);
        List<Long> primeNum = getPrimeNum(target);
        int index = 0;
        StringBuilder sb = new StringBuilder();

        while (index < primeNum.size() && target != 1) {
            long current = primeNum.get(index);
            if (target % current == 0) {
                target = target / current;
                sb.append(current + " ");
            } else {
                index++;
            }
        }

        String result = sb.toString();
        if (result.length() >= 1) {
            System.out.println(result.substring(0, result.length() - 1));
        } else {
            System.out.println(result);
        }
    }

    public static List<Long> getPrimeNum(long num) {
        List<Long> temp = new ArrayList<>();
        List<Long> result = new ArrayList<>();
        for (long i = 2; i <= num / 2; i++) {
            if (!temp.contains(i)) {
                if (num % i == 0) {
                    temp.add(i);
                    long num2 = num / i;
                    temp.add(num2);
                }
            }
        }
        for (Long current : temp) {
            boolean isPrime = true;
            for (long j = 2; j <= Math.sqrt(current); j++) {
                if (current % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                result.add(current);
            }
        }

        return result;
    }
}
