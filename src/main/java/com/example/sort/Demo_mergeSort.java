package com.example.sort;

import java.util.Arrays;

/**
 * 归并排序实现
 */
public class Demo_mergeSort {

    public static void main(String[] args) {
        int[] ints = {12, 13, 0, 9, 4, 7, 45};
        int[] ints1 = {45, 12};
        Demo_mergeSort demo_quickSort = new Demo_mergeSort();
        demo_quickSort.mergeSort(ints);
        System.out.println(Arrays.toString(ints));
        demo_quickSort.mergeSort(ints1);
        System.out.println(Arrays.toString(ints1));
    }

    public void mergeSort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
    }

    public void mergeSort(int[] nums, int begin, int end, int[] temp) {
        if (end <= begin) {
            return;
        }
        int mid = (begin + end) / 2;
        mergeSort(nums, begin, mid, temp);
        mergeSort(nums, mid + 1, end, temp);
        merge(nums, begin, mid + 1, end, temp);
    }

    void merge(int[] nums, int begin, int mid, int end, int[] temp) {
        int index = begin, start = begin, midt = mid;
        while (begin < midt && mid <= end) {
            if (nums[begin] > nums[mid]) {
                temp[index++] = nums[mid++];
            } else {
                temp[index++] = nums[begin++];
            }
        }
        while (begin < midt) { // 左剩省下的元素
            temp[index++] = nums[begin++];
        }
        while (mid <= end) {  // 右边剩下的元素
            temp[index++] = nums[mid++];
        }
        while (start <= end) {
            nums[start] = temp[start];
            start++;
        }
    }
}
