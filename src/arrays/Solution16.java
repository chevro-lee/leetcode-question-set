package arrays;

/**
 * Author li.ling
 * Description lc 合并两个有序数组 - 双指针
 *               面试题 10.01. 合并排序的数组
 * Date 2021/3/24 16:15
 */
public class Solution16 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        // 将num1数组复制到新的数组，num1用来输出
        int[] num1_move = new int[m];
        System.arraycopy(nums1, 0, num1_move, 0, m);
        while (i < m && j < n) {
            if (num1_move[i] <= nums2[j]) {
                nums1[k] = num1_move[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        // 将剩余部分的数组复制到nums1的后面
        if (i < m) {
            System.arraycopy(num1_move, i, nums1, k, m - i);
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, k, n - j);
        }
    }
}
