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

        String s = "abcabcbb";
        String s1 = "dvdf";
        String s2 = "pwwkew";

        P_0003_lengthOfLongestSubstring binarySearch = new P_0003_lengthOfLongestSubstring();
        System.out.println(binarySearch.lengthOfLongestSubstring(s));
        //System.out.println(binarySearch.lengthOfLongestSubstring(s1));
        //System.out.println(binarySearch.lengthOfLongestSubstring(s2));
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;//用于记录最大不重复子串的长度
        int left = 0;//滑动窗口左指针
        for (int i = 0; i < s.length() ; i++)
        {
            /**
             1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
             此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；

             2、如果当前字符 ch 包含在 map中，此时有2类情况：
             1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
             那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
             2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
             而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
             随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
             应该不变，left始终为2，子段变成 ba才对。

             为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
             另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
             因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
             */
            if(map.containsKey(s.charAt(i)))
            {
                left = Math.max(left , map.get(s.charAt(i))+1);
            }
            //不管是否更新left，都要更新 s.charAt(i) 的位置！
            map.put(s.charAt(i) , i);
            maxLen = Math.max(maxLen , i-left+1);
            System.out.println("char=" + s.charAt(i) + ",left=" + left + ",maxLet=" + maxLen + ",map=" + map.toString() );
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring1(String s) {

        if (s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int[] a = new int[s.length()];
        Set<Character> set = new HashSet<>(s.length() / 75 * 100);
        set.add(s.charAt(0));
        int max = 1;
        a[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            char target = s.charAt(i);

            if (set.contains(target)) {
                set.clear();
            }
            set.add(target);

            int size = set.size();
            if (size > max) {
                max = size;
            }
        }
        return max;

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
