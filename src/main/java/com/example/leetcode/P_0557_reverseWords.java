package com.example.leetcode;

import java.util.Arrays;

/**
 *
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * */
public class P_0557_reverseWords {

    public static void main(String[] args) {

        String a = "hannah" ;

        P_0557_reverseWords binarySearch = new P_0557_reverseWords();
        binarySearch.reverseWords(a);
        System.out.println(Arrays.toString( a ));
    }

    public String reverseWords(String s) {

    }


}
