package com.example.leetcode;

/**
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0540_singleNonDuplicate {

    public static void main(String[] args) {

        int a[] = {1,1,2};
        int b[] = {1,1,7,8,8};
        int c[] = {1,1,7,8,8,9,9,10,10};
        int d[] = {1,1,7,7,8,9,9};
        int e[] = {1,2,2,4,4,8,8,9,9};
        P_0540_singleNonDuplicate duplicate = new P_0540_singleNonDuplicate();
        System.out.println(duplicate.singleNonDuplicate(a));
        System.out.println(duplicate.singleNonDuplicate(b));
        System.out.println(duplicate.singleNonDuplicate(c));
        System.out.println(duplicate.singleNonDuplicate(d));
        System.out.println(duplicate.singleNonDuplicate(e));
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }

        int mid = nums.length/2,left=0,right=nums.length-1;
        int lEle,rEle,tEle;//左边元素的个数、右边元素的个数、总共元素的个数

        while(left < mid  && right > mid){
            tEle = right -left + 1;
            if (nums[mid]==nums[mid-1]){
                lEle = mid-left -1;
                rEle = tEle - lEle - 2;
            } else if (nums[mid]==nums[mid+1]){
                lEle = mid - left;
                rEle = tEle - lEle -2;
            } else {
                return nums[mid];
            }

            if (lEle%2==0){ //左边元素为偶数个，说明target在右边
                left= left + lEle + 2 ;
            }
            if (rEle%2==0){ //右边边元素为偶数个，说明target在左边
                right= right - rEle - 2 ;
            }
            mid = (right + left )/2;
        }
        return nums[mid];

    }
}
