package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 *
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0003_lengthOfLongestSubstring {

    public static void main(String[] args) {

        String s = "abcdefgbhijk";
        String s1 = "abba";
        String s2 = "pwwkew";

        P_0003_lengthOfLongestSubstring binarySearch = new P_0003_lengthOfLongestSubstring();
        //System.out.println(binarySearch.lengthOfLongestSubstring(s));
        System.out.println(binarySearch.lengthOfLongestSubstring(s1));
        //System.out.println(binarySearch.lengthOfLongestSubstring(s2));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s==null){return 0;}
        if (s.length()<=1){return s.length();}
        HashMap<Character,Integer> map = new HashMap<>();

        int maxLen = 1,startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                startIndex = Math.max( startIndex,map.get(c) + 1 );
            }
            maxLen = Math.max(maxLen,i-startIndex +1);
            map.put(c,i);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring1(String s) {
        int maxLen = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                left = Math.max( map.get(c) + 1,left);
            }
            map.put(c, i);
            maxLen = Math.max(maxLen,i-left+1);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {

        if (s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int[] a = new int[s.length()];
        int max = 1;
        a[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            char target = s.charAt(i);
            int j = 0;
            for (; j < a[i - 1]; j++) {
                if (target == s.charAt(i - j - 1)) {
                    break;
                }
            }
            a[i] = j + 1;
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

}
