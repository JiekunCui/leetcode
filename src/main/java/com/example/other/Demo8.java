package com.example.other;

import java.nio.charset.StandardCharsets;

public class Demo8 {

    public static void main(String[] args) {
        String s = "崔介坤";
        for (int i =0;i < s.length();i++){
            System.out.println(s.charAt(i));
        }

        char[] chars = s.toCharArray();
        for (int i =0;i < chars.length;i++){
            System.out.println(chars[i]);
        }

        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        for (int i =0;i < bytes.length;i++){
            System.out.println(bytes[i]);
        }
    }
}
