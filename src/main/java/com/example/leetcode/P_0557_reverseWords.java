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

        String a = "hello I'm jack" ;
        String b = "Let's take LeetCode contest" ;
        String c = "a" ;
        String d = "You like me";

        P_0557_reverseWords binarySearch = new P_0557_reverseWords();

        System.out.println(binarySearch.reverseWords(a));
        System.out.println(binarySearch.reverseWords(b));
        System.out.println(binarySearch.reverseWords(c));
        System.out.println(binarySearch.reverseWords(d));
    }

    public String reverseWords(String s) {
        if (s.length()<2){
            return s;
        }
        char[] chars = s.toCharArray();
        int lastSpace = 0;
        for (int j=0; j<chars.length ; j++) {
            if (chars[j] == ' ' || j==chars.length-1){
                int high = j-1;
                if (j==chars.length-1){
                    high = j;
                }
                reverseString(chars,lastSpace,high);
                lastSpace = j+1;
            }
        }
        return new String(chars);
    }


    public void reverseString(char[] s,int low,int high) {
        if ( high-low<1 ){
            return;
        }
        while (low<high){
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }


}
