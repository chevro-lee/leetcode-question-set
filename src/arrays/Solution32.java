package arrays;

/**
 * Author li.ling
 * Description lc 搜索插入位置 二分查找
 * Date 2021/4/2 20:14
 */
public class Solution32 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
