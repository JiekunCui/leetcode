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

        System.out.println(binarySearch.findLast(a,  8));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[] {-1, -1};
        }

        //找出一个出现的位置
        //int[] index = getIndex(nums, 0, nums.length - 1, target);
        //
        //if (index==null){
        //    return new int[] {-1, -1};
        //}
        //
        int[] ret = new int[2];
        //
        //ret[0] = findFirst(nums,index[0],index[1],target);
        //ret[1] = findLast(nums,index[1],index[2],target);
        ret[0] = findFirst(nums,0,nums.length-1,target);
        ret[1] = findLast(nums,0,nums.length-1,target);

        return ret;
    }

    public int findFirst(int[] nums, int target){
        return findFirst(nums,0,nums.length-1,target);
    }

    public int findLast(int[] nums, int target){
        return findLast(nums,0,nums.length-1,target);
    }

    public int findFirst(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            System.out.println(left + "," + mid + "," + right);
            if (nums[mid] < target) {
                left = mid + 1 ;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        System.out.println(left  + "," + right);
        if (nums[left]==target){
            return left;
        }

        return -1;
    }

    public int findLast(int[] nums, int low, int high, int target) {
        while(low <= high){
            int mid = low + (high-low)/2;
            System.out.println(low + "," + mid + "," + high);
            if(nums[mid] <= target){
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }

        }
        System.out.println(low  + "," + high);
        if (nums[high] == target) {
            return high;
        } else {
            return -1;
        }
    }
    public int findLast1(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1 ;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if(nums[right] == target){
            return right;
        }
        return -1;
    }

}
