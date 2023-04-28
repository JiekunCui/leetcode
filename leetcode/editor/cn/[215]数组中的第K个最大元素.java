//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2110 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return nums[quickSort(nums, 0, len-1, len-k)];
    }


    public int quickSort(int[] arr, int left, int right,int k) {
        int pivotIndex = partition(arr, left, right);

        if (pivotIndex == k){return pivotIndex;}

        if (k < pivotIndex){
            return quickSort(arr, left, pivotIndex - 1,k);
        }else {
            return quickSort(arr, pivotIndex + 1, right,k);
        }
    }

    private int partition(int[] arr, int low, int high) {
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
//leetcode submit region end(Prohibit modification and deletion)
