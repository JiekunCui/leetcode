package com.example.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P_0239_maxSlidingWindow {

    public static void main(String[] args) {

        int a[] = {1,3,-1,-3,5,3,6,7};
        int c[] = {1, 4, 7, 8, 9, 10, 15};
        int b[] = {123, 54, 47, 38, 29, 19, 15};

        P_0239_maxSlidingWindow binarySearch = new P_0239_maxSlidingWindow();

        System.out.println(Arrays.toString( binarySearch.maxSlidingWindow(b, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return nums;
        }
        int[] arr = new int[len - k + 1];
        int arr_index = 0;
        //我们需要维护一个单调递增的双向队列
        Deque<Integer> deque = new LinkedList<>();

        for (int j = 0; j < len; j++) {

            //队尾删除比nums[j] 小的下标
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
                deque.removeLast();
            }

            deque.offerLast(j);

            //队头删除当前窗口之外的值
            while (j-k+1>deque.peekFirst() ){
                deque.removeFirst();
            }

            if (j>=k-1){
                arr[arr_index++] = nums[deque.peekFirst()];
            }
        }
        return arr;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length==0 || nums.length < k){
            return  new int[0];
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int[] ret = new int[nums.length-k+1];

        int l=0,r=0,index=0;

        while (r < k) {
            Integer integer = treeMap.get(nums[r]);
            if (integer == null){
                treeMap.put(nums[r],1);
            }else {
                treeMap.put(nums[r],integer+1);
            }
            r++;
        }

        r--;
        while (true) {
            Integer lastKey = treeMap.lastKey();
            ret[index++] = lastKey;
            r++;
            if (r == nums.length){
                break;
            }

            Integer rInt = treeMap.get(nums[r]);
            if (rInt == null){
                treeMap.put(nums[r],1);
            }else {
                treeMap.put(nums[r],rInt+1);
            }

            Integer lInt = treeMap.get(nums[l]);
            if (lInt==null || lInt==1){
                treeMap.remove(nums[l]);
            }else {
                treeMap.put(nums[l],lInt-1);
            }
            l++;
        }

        return ret;

    }
}
