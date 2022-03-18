package com.example.leetcode;

import java.util.HashMap;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0005_longestPalindrome {

    public static void main(String[] args) {

        String s = "babad";
        String s1 = "cbbd";
        String s2 = "pwwkew";

        P_0005_longestPalindrome binarySearch = new P_0005_longestPalindrome();
        System.out.println(binarySearch.longestPalindrome(s));
        System.out.println(binarySearch.longestPalindrome(s1));
        System.out.println(binarySearch.longestPalindrome(s2));
    }


    public String longestPalindrome(String s) {

        int posMax = 0,maxlen=0;
        for (int i = 0; i < s.length(); i++) {
            int js = expand(s,i,i);
            int os = expand(s,i,i+1);
            int iMax = Math.max(js,os);

            if (maxlen < iMax){
                posMax = i;
            }

            maxlen = Math.max(iMax,maxlen);
        }

        if (maxlen%2==0){
            return new String(s.toCharArray(),posMax-maxlen/2 +1,maxlen);
        }

        return new String(s.toCharArray(),posMax-maxlen/2 ,maxlen);
    }

    private int expand(String s,int left,int right){
        while (left>=0 && right < s.length()){
            if (s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }else {
                break;
            }
        }

        return right-left+1 - 2;
    }

    /**
     * O(n^3)
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int maxLeft=0,maxRight=0;
        for (int left = 0; left < s.length() ; left++)
        {
            int tLeft=left,tRight=left;
            for (int right = s.length()-1;right>left;right--){
                if (s.charAt(left)==s.charAt(right)){
                    int tL=left,tR=right;
                    while (tL < tR ){
                        if (s.charAt(tL) == s.charAt(tR)){
                            tL++;
                            tR--;
                        }else {
                            break;
                        }
                    }
                    if (tL>=tR){
                        tLeft = left;
                        tRight= right;
                        break;
                    }
                }
            }
            if (tRight-tLeft > maxRight - maxLeft){
                maxRight=tRight;
                maxLeft=tLeft;
            }
        }

        return new String(s.toCharArray(),maxLeft,maxRight-maxLeft+1);
    }


}
