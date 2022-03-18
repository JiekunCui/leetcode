package com.example.leetcode;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 给定一个包含n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 
 *
 * 提示：
 *
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 * 
 *
 * 进阶：
 *
 * 如何证明 nums 中至少存在一个重复的数字?
 * 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
 *
 */
public class P_0287_findDuplicate {

    public static void main(String[] args) throws Exception {
        P_0287_findDuplicate findDuplicate = new P_0287_findDuplicate();
        //System.out.println(findDuplicate.findDuplicate(new int[]{1,3,4,2,2}));
        //System.out.println(findDuplicate.findDuplicate(new int[]{3,3,3,4,2}));;
        System.out.println(findDuplicate.findDuplicate(findDuplicate.getNums()));

    }

    public int findDuplicate(int[] nums) {

        /**
         快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
         注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
         因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
         即按照寻找链表环入口的思路来做
         **/
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }

    private int[] getNums() throws Exception {

        InputStream fileInputStream = this.getClass().getClassLoader().getResourceAsStream("data.txt");
        InputStreamReader inputStream = new InputStreamReader(fileInputStream);
        BufferedReader reader = new BufferedReader(inputStream);
        int[] nums = new int[100001];

        String s = null;
        int i = 0;
        while ((s = reader.readLine())!=null){
            Integer integer = Integer.valueOf(s);
            nums[i++] = integer;
        }

        return nums;
    }
    
}
