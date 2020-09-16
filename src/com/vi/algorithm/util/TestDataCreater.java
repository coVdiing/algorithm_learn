package com.vi.algorithm.util;

import java.io.*;

public class TestDataCreater {
    public static void createTestArrayFile() throws IOException {
        //在当前类路径下的algorithm下生成测试数据
        File file = new File("./algorithm/reverse_order_array.txt");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        for (int i = 100000; i > 0; i--) {
            writer.write(i+"\r\n");
        }
        writer.flush();
        writer.close();
        System.out.println("逆序数组已经生成");
    }

    public static void main(String[] args) throws IOException {
        createTestArrayFile();
    }
}
