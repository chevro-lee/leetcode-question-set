package arrays;

/**
 * Author li.ling
 * Description lc 长度最小的子数组 滑动窗口法
 * Date 2021/3/26 14:58
 */
public class Solution21 {


    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 || s == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        // 刚开始，左指针和右指针都指向第一个元素位置，随后右指针向右移动，直到大于等于s
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                // 右指针指向的位置和左指针之间的差值+1，即为此时大于等于s的子数据长度
                ans = Math.min(ans, right - left + 1);
                // 移动左指针，尝试寻找更小的子数组长度
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
