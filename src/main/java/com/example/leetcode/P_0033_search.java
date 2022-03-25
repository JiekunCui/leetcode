package com.example.leetcode;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0033_search {

    public static void main(String[] args) {

        int a[] = {4,5,6,7,0,1,2,3};

        P_0033_search binarySearch = new P_0033_search();

        //System.out.println(binarySearch.search(a, 0));
        //System.out.println(binarySearch.search(a, 7));
        //System.out.println(binarySearch.search(a, 1));
        //System.out.println(binarySearch.search(a, 2));
        System.out.println(binarySearch.search(a, 3));
        System.out.println(binarySearch.search(a, 4));
        //System.out.println(binarySearch.search(a, 5));
    }

    public int search(int[] nums, int target) {
            if (nums.length==0 ){
                return  -1;
            }

            int len = nums.length;
            int low = 0,high = len -1 ;
            while ( low <= high ){
                int mid = low + (high-low)/2;

                if (nums[mid] < target){
                    if ( nums[low] <  nums[mid]){ // low 至 mid 这段 是升序的，且 target不在这部分里面
                        low = mid + 1;;
                    }else { // low 至 mid 这段 不是升序的，说明 mid 至 high这段  是升序的
                        if (target <= nums[high]){
                            low = mid + 1;
                        }else {
                            high = mid - 1;
                        }
                    }
                }else if (nums[mid] > target) {
                    if (nums[mid] < nums[high]){ // mid 至 high 这段 是升序的，且 target不在这部分里面
                        high = mid - 1;
                    }else { // mid 至 high 这段 不是升序的，说明 low 至 mid这段  是升序的
                        if (target >= nums[low]){
                            high = mid - 1;
                        }else {
                            low = mid + 1;
                        }
                    }
                }else {
                    return mid;
                }
            }
            return -1;
    }
}
