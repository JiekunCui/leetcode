package com.example.leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * 示例 5:
 *
 * 输入: nums = [1], target = 0
 * 输出: 0
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为无重复元素的升序排列数组
 * -104 <= target <= 104
 * 通过次数631,222提交次数1,37
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0035_searchInsert {

    public static void main(String[] args) {

        int a[] = {1,3,5,6};
        int b[] = {1,3};
        int c[] = {1, 4, 7, 8, 9, 10, 15};

        P_0035_searchInsert binarySearch = new P_0035_searchInsert();

        System.out.println(binarySearch.searchInsert(a,5));
        System.out.println(binarySearch.searchInsert(a,2));
        System.out.println(binarySearch.searchInsert(a,7));
        System.out.println(binarySearch.searchInsert(a,0));
        System.out.println(binarySearch.searchInsert(b,2));
        System.out.println(binarySearch.searchInsert(c,15));
    }

    public int searchInsert(int[] nums, int target) {
            if (nums.length==0 || target < nums[0] ){
                return  0;
            }
            if ( target > nums[nums.length-1]){
                return nums.length;
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
            if (nums[left] < target){
                return left + 1;
            }
            return left;
    }
}
