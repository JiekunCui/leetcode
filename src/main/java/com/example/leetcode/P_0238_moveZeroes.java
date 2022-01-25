package com.example.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0238_moveZeroes {

    public static void main(String[] args) {

        int a[] = {1, 0, 1, 0, 2, 5, 6, 0};
        P_0238_moveZeroes binarySearch = new P_0238_moveZeroes();

        System.out.println(Arrays.toString(binarySearch.moveZeroes(a)));
        //System.out.println(Arrays.toString( binarySearch.moveZeroes(b )));
        //System.out.println(Arrays.toString( binarySearch.rotate(a, 7)));
        //System.out.println(Arrays.toString( binarySearch.rotate(a, 0)));
        //System.out.println(Arrays.toString( binarySearch.rotate(b, 2)));
        //System.out.println(Arrays.toString( binarySearch.rotate(c, 15)));
    }

    public int[] moveZeroes(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int i=0,j = 0;
        for (; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[j] = nums[i];
                j++;
            }
        }
        for (; j < nums.length; j++) {
            nums[j]=0;
        }
        return nums;
    }

}
