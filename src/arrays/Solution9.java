package arrays;

import java.util.Arrays;

/**
 * Author li.ling
 * Description lc 移动零 - 双指针解法
 * Date 2021/3/18 23:29
 */
public class Solution9 {

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int n = nums.length;
        int left = 0;
        int right = 0;
        int temp;
        while (right < n) {
            // 当右指针指向的数不等于0时，与左边的数的交换，换到最后，右边的数都是0了
            if (nums[right] != 0) {
                temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                // 交换完成，左指针继续向右移动
                left++;
            }
            // 否则继续移动右指针
            right++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        Solution9 solution9 = new Solution9();
        solution9.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
