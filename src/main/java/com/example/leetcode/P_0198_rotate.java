package com.example.leetcode;

import java.util.Arrays;

/**
 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

  

 示例 1:

 输入: nums = [1,2,3,4,5,6,7], k = 3
 输出: [5,6,7,1,2,3,4]
 解释:
 向右轮转 1 步: [7,1,2,3,4,5,6]
 向右轮转 2 步: [6,7,1,2,3,4,5]
 向右轮转 3 步: [5,6,7,1,2,3,4]
 示例 2:

 输入：nums = [-1,-100,3,99], k = 2
 输出：[3,99,-1,-100]
 解释:
 向右轮转 1 步: [99,-1,-100,3]
 向右轮转 2 步: [3,99,-1,-100]
  

 提示：

 1 <= nums.length <= 105
 -231 <= nums[i] <= 231 - 1
 0 <= k <= 105
  

 进阶：

 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/rotate-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0198_rotate {

    public static void main(String[] args) {

        int a[] = {1,2,3,4,5,6,7,8};
        int b[] = {-1,-100,3,99};
        int c[] = {1, 4, 7, 8, 9, 10, 15};

        P_0198_rotate binarySearch = new P_0198_rotate();

        System.out.println(Arrays.toString( binarySearch.rotate(a, 5)));
        System.out.println(Arrays.toString( binarySearch.rotate(b, 2)));
        //System.out.println(Arrays.toString( binarySearch.rotate(a, 7)));
        //System.out.println(Arrays.toString( binarySearch.rotate(a, 0)));
        //System.out.println(Arrays.toString( binarySearch.rotate(b, 2)));
        //System.out.println(Arrays.toString( binarySearch.rotate(c, 15)));
    }

    public int[] rotate(int[] nums, int target) {
            if (nums.length==0 || nums.length==1 ){
                return  nums;
            }
            target = target % (nums.length);
            reverse(nums,0,nums.length-1);
            reverse(nums,0,target-1);
            reverse(nums,target,nums.length-1);

            return nums;
    }

    public void reverse(int[] nums, int begin,int end) {
        while(begin < end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin ++;
            end--;
        }
    }


}
