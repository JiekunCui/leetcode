package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *  
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0076_minWindow {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String target = "ABC";

        P_0076_minWindow binarySearch = new P_0076_minWindow();
        System.out.println(binarySearch.minWindow(s,target));
    }

    public String minWindow(String s, String target) {
        if (s == null || s.length() == 0 || target == null ||
            target.length() == 0 || s.length() < target.length()) {
            return "";
        }

        int arrLen = 'z'-'A' + 1 ;
        int[] tArr = new int[arrLen];
        int[] sArr = new int[arrLen];
        int l = 0,r = 0,minStart =-1,minLen = Integer.MAX_VALUE;
        for (int i = 0; i < target.length(); i++) {
            tArr[target.charAt(i)-'A']++;
        }

        while ( l<=r && r<s.length() ) {
            sArr[s.charAt(r++)-'A']++; //新增窗口右移后增加的字母
            while (isContains(sArr,tArr)){
                if (r-l+1 < minLen){
                    minLen = r-l+1;
                    minStart = l;
                }
                sArr[s.charAt(l ++)-'A']--;//减去窗口右移后被抛弃的字母
            }
        }
        if (minStart == -1){ return "";}
        return s.substring(minStart,minStart + minLen-1);
    }

    private boolean isContains(int[] sArr,int[] tArr){
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] < tArr[i]){
                return false;
            }
        }
        return true;
    }

}
