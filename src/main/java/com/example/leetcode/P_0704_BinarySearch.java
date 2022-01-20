package com.example.leetcode;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *  
 *
 * 提示：
 *
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0704_BinarySearch {

    public static void main(String[] args) {

        int a[] = {1, 2};
        int b[] = {1, 2, 7, 8, 22};
        int c[] = {1, 4, 7, 8, 9, 10, 15};

        P_0704_BinarySearch binarySearch = new P_0704_BinarySearch();

        System.out.println(binarySearch.search(a,2));
        System.out.println(binarySearch.search(b,8));
        System.out.println(binarySearch.search(c,15));
    }

    public int search(int[] nums, int target) {
        if (nums.length==0){
            return  -1;
        }

        //不在范围内
        if (target < nums[0] || target > nums[nums.length-1]){
            return -1;
        }

        int left=0,right=nums.length-1;

        while(left < right){
            int mid = (left + right)/2;

            if (nums[mid]  < target){
                left= mid +1;
            }else if (nums[mid] > target){
                right = mid -1;
            }else {
                return mid;
            }
        }
        if (nums[left] != target){
            return -1;
        }
        return left;
    }
}
