package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *  
 *
 * 提示:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0438_findAnagrams {

    public static void main(String[] args) {

        String s = "abab";
        String target = "ab";

        P_0438_findAnagrams binarySearch = new P_0438_findAnagrams();
        System.out.println(binarySearch.findAnagrams(s,target));
    }

    public List<Integer> findAnagrams(String s, String target) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || target == null ||
            target.length() == 0 || s.length() < target.length()) {
            return list;
        }

        int[] tArr = new int[26];
        int[] sArr = new int[26];
        int l = 0,r = 0;
        for (r = 0; r < target.length(); r++) {
            tArr[target.charAt(r)-'a']++;
            sArr[s.charAt(r)-'a']++;
        }

        r=target.length()-1;
        while (true) {

            if(Arrays.equals(sArr,tArr)){ //窗口内的字母数量均相等，说明匹配到了对应得结果
                list.add(l);
            }

            //每次循环l,r都要同时右移，保持窗口长度(r-l+1)跟 target长度相等
            ++r;
            if (r>=s.length()){
                break;
            }
            sArr[s.charAt(r)-'a']++; //新增窗口右移后增加的字母
            sArr[s.charAt(l++)-'a']--;//减去窗口右移后被抛弃的字母
        }
        return list;
    }

    public List<Integer> findAnagrams1(String s, String target) {
        List<Integer> list = new ArrayList<>();
        if (s==null||s.length()==0 || target==null||target.length()==0
        || s.length() < target.length()){
            return list;
        }

        Map<Character, Integer> tempMap ;
        for (int i = 0; i < s.length(); i++) {
            tempMap = getAllCharMap(target);
            for (int j = i; j-i < target.length() && j < s.length(); j++) {
                char c = s.charAt(j);
                if (tempMap.containsKey(c)){
                    dcrease(tempMap,c);
                }else {
                    break;
                }
            }

            if (tempMap.size()==0){
                list.add(i);
            }
        }

        return list;
    }

    private void dcrease(Map<Character, Integer> tempMap, char c) {
        Integer sum = tempMap.get(c);
        if (sum == 1) {
            tempMap.remove(c);
        } else {
            tempMap.put(c, --sum);
        }
    }

    private Map<Character,Integer> getAllCharMap(String target){
        HashMap<Character,Integer> map = new HashMap<Character,Integer>((int)(target.length() / 0.75));
        for (int i = 0; i < target.length(); i++) {
            Character c = target.charAt(i);
            if (map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else {
                map.put(c,1);
            }
        }
        return map;
    }
}
