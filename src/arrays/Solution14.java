package arrays;

import java.util.Arrays;

/**
 * Author li.ling
 * Description lc 数组中的第K个最大元素 -- 快速排序取值法
 * Date 2021/3/24 10:08
 */
public class Solution14 {

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int start, int end) {
        // 区间只有一个数
        if (start >= end) {
            return;
        }
        // 选择第一个数作为基准数
        int pivot = nums[start];
        int i = start;
        int j = end;
        // 当num[i]小于基准数，且i<j，不移动元素，只移动i索引
        while (i < j && nums[i] < pivot) {
            i++;
        }
        // 当num[j]小于基准数，且i<j，不移动元素，只移动j索引
        while (i < j && nums[j] > pivot) {
            j--;
        }
        int temp = 0;
        if (nums[i] == nums[j] && i < j) {
            i++;
        } else {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,3,2,1,5,6,4};
        Solution14 solution14 = new Solution14();
        int kthLargest = solution14.findKthLargest(nums, 2);
        System.out.println(Arrays.toString(nums));
        System.out.println(kthLargest);
    }
}
