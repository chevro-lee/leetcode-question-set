package arrays;

/**
 * Author li.ling
 * Description lc 盛最多水的容器 - 双指针碰撞法
 * Date 2021/3/25 15:40
 */
public class Solution20 {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left],height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        Solution20 solution20 = new Solution20();
        int maxArea = solution20.maxArea(nums);
        System.out.println(maxArea);
    }
}
