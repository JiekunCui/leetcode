package com.example.leetcode;

import java.util.Arrays;

/**
 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

 示例 1：

 输入：nums = [-4,-1,0,3,10]
 输出：[0,1,9,16,100]
 解释：平方后，数组变为 [16,1,0,9,100]
 排序后，数组变为 [0,1,9,16,100]
 示例 2：

 输入：nums = [-7,-3,2,3,11]
 输出：[4,9,9,49,121]

 提示：

 1 <= nums.length <= 104
 -104 <= nums[i] <= 104
 nums 已按 非递减顺序 排序

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0977_sortedSquares {

    public static void main(String[] args) {

        int a[] = {-4,-1,0,3,10};
        int b[] = {-7,-3,2,3,11};
        int c[] = {1, 4, 7, 8, 9, 10, 15};

        P_0977_sortedSquares binarySearch = new P_0977_sortedSquares();

        System.out.println(Arrays.toString( binarySearch.sortedSquares(a) ));
        System.out.println(Arrays.toString( binarySearch.sortedSquares(b) ));
    }

    public int[] sortedSquares(int[] nums ) {
        int low = 0,high = nums.length-1,p=nums.length-1;
        int ret[] = new int[nums.length];
        while (low <= high){
            int lowP = nums[low] * nums[low];
            int highP = nums[high] * nums[high];
            if (lowP < highP){
                ret[p] = highP;
                high --;
            }else {
                ret[p] = lowP;
                low ++;
            }
            p--;
        }
        return ret;
    }
}
