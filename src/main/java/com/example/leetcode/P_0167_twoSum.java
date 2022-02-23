package com.example.leetcode;

import java.util.Arrays;

/**
 * 给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 *  
 * 示例 1：
 *
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 示例 2：
 *
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 示例 3：
 *
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 非递减顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0167_twoSum {

    public static void main(String[] args) {

        int a[] = {2,7,11,15};
        int b[] = {-1,0};
        int c[] = {2,3,4,9,65,69};
        P_0167_twoSum binarySearch = new P_0167_twoSum();

        System.out.println(Arrays.toString(binarySearch.twoSum(a,9)));
        System.out.println(Arrays.toString( binarySearch.twoSum(b,-1 )));
        System.out.println(Arrays.toString( binarySearch.twoSum(c, 74)));
        //System.out.println(Arrays.toString( binarySearch.rotate(a, 0)));
        //System.out.println(Arrays.toString( binarySearch.rotate(b, 2)));
        //System.out.println(Arrays.toString( binarySearch.rotate(c, 15)));
    }


    public int[] twoSum(int[] nums,int target) {
        //return binarySeach(nums,target);
        return twoPointer(nums,target);
    }

    private int[] twoPointer(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j;) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] {i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    public int[] binarySeach(int[] nums,int target) {
        int[] result = new int[2];
        int low=0;
        int high=nums.length-1;
        while (low<=nums.length-2){
            int sumMax = nums[low] + nums[high];
            if(sumMax >= target) {
                int search = search(nums, low + 1, high, target - nums[low]);
                if (search!=-1) {
                    result = new int[]{low+1,search +1};
                    break;
                }
            }
            low ++;
        }
        return result;
    }

    public int search(int[] nums,int left,int right,int target) {
        if (nums.length==0){
            return  -1;
        }
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
