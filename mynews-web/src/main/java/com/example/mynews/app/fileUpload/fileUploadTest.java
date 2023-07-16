package com.example.mynews.app.fileUpload;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class fileUploadTest {
    public static void main(String[] args) throws Exception {
        //从控制台读取多字符输入
//        char c;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("输入字符, 按下 'q' 键退出。");
//        do {
//            c = (char) br.read();
//            System.out.println(c);
//        } while (c != 'q');

        //从控制台读取字符串
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("end"));
    }


}
