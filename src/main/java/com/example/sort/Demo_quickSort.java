package com.example.sort;

import java.util.Arrays;

public class Demo_quickSort {

    public static void main(String[] args) {
        //int[] ints = {5, 2, 7, 1, 9, 4, 6, 8, 3};
        int[] ints = {5, 5, 5,5, 5,5};
        int[] ints1 = {45, 12};
        Demo_quickSort demo_quickSort = new Demo_quickSort();
        System.out.println(Arrays.toString(ints));
        //demo_quickSort.quickSort1(ints, 0, ints.length - 1);
        demo_quickSort.quickSort(ints, 0, ints.length - 1);
        // demo_quickSort.quickSort(ints1, 0, ints.length-1);
        System.out.println(Arrays.toString(ints));

        Arrays.sort(ints1);
        System.out.println(Arrays.toString(ints1));

    }

    //public void quickSort1(int[] nums, int begin, int end) {
    //
    //    if (end - begin <= 0) {
    //        return;
    //    }
    //
    //    int left = begin, right = end;
    //    int povit = nums[left]; //基准
    //    while (right > left) {
    //        //先从右面找一个比 povit 小的
    //        while (right > left && nums[right] > povit) {
    //            right--;
    //        }
    //        //再从左边找一个比base大的
    //        while (right > left && nums[left] <= povit) {
    //            left++;
    //        }
    //
    //        //如果right跟left不相等，交换right，left对应的值，继续下一轮搜索
    //        if (right > left) {
    //            System.out.println(
    //                    String.format("%s,povit=%s,right=%s,left=%s,begin=%s,end=%s", Arrays.toString(nums), povit, right, left,
    //                                  begin, end));
    //            swap(nums, right, left);
    //        }
    //    }
    //    System.out.println(
    //            String.format("%s,povit=%s,right=%s,left=%s,begin=%s,end=%s", Arrays.toString(nums), povit, right, left,
    //                          begin, end));
    //
    //    //quickSort1(nums, begin, right - 1);
    //    //quickSort1(nums, right + 1, end);
    //
    //}


    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int begin = low,end = high;
        int pivot = low;
        int pivotValue = arr[pivot];
        while (low < high) {
            while (low < high && arr[high] >= pivotValue) {
                high--;
            }
            while (low < high && arr[low] <= pivotValue) {
                low++;
            }
            swap(arr, low, high);
        }
        swap(arr, pivot, low);
        return low;
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
