package arrays;

/**
 * Author li.ling
 * Description lc 移除元素 - 双指针解法
 * Date 2021/3/18 23:52
 */
public class Solution10 {

    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int n = nums.length;
        while (j < n) {
            // 如果j指向的值不等于要删的值，i，j同时向后移动，不等于val的j指向的值，覆盖等于val的i指向的值
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            // 如果相等，j向后移动
            j++;
        }
        return i;
    }
}
