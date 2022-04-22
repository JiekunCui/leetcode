package com.example.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class P_0128_longestConsecutive {

    public static void main(String[] args) {

        int a[] = {0,3,7,2,5,8,4,6,0,1};

        P_0128_longestConsecutive binarySearch = new P_0128_longestConsecutive();

        System.out.println(binarySearch.longestConsecutive(a));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length <=1){
            return nums.length;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num - 1)){
                int temLen = 1;

                while (set.contains(num+1)){
                    temLen ++;
                    num ++;
                }
                maxLen = Math.max(temLen,maxLen);
            }
        }
        return maxLen;
    }

}
