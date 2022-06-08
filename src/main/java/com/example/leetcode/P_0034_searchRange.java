package com.example.leetcode;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109<= nums[i]<= 109
 * nums是一个非递减数组
 * -109<= target<= 109
 * 通过次数475,052提交次数1,125,481
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0034_searchRange {

    public static void main(String[] args) {

        int a[] = {5,7,7,8,8,10};

        P_0034_searchRange binarySearch = new P_0034_searchRange();

        System.out.println(Arrays.toString(binarySearch.searchRange(a,  8)));
        System.out.println(Arrays.toString(binarySearch.searchRange(a,  7)));
        System.out.println(Arrays.toString(binarySearch.searchRange(a,  10)));
        System.out.println(Arrays.toString(binarySearch.searchRange(a,  5)));
    }
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[] {-1, -1};
        }

        int firstPos = findFirstPos(nums,target);

        if (firstPos==-1){
            return new int[] {-1, -1};
        }

        int lastPos = findLastPos(nums,target);
        return new int[]{firstPos,lastPos};
    }

    private int findLastPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<right){

            //这里和寻找第一个位置不同，
            //nums = [5,7,7,8,8,10], target = 8
            //这里 left = 3,right=4 时 如果不加1，始终有mid=3 则会出现死循环
            int mid = (right+left + 1)>>1;
            if (nums[mid]<target){
                left = mid + 1;
            }else if (nums[mid]==target){
                left=mid;
            }else {
                right = mid-1;
            }
        }
        return left;
    }

    private int findFirstPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int mid = (right+left)>>1;
            if (nums[mid]<target){
                left = mid + 1;
            }else if (nums[mid]==target){
                right=mid;
            }else {
                right = mid-1;
            }
        }
        if (nums[left]==target){
            return left;
        }
        return -1;
    }

}
