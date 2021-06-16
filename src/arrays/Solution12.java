package arrays;

/**
 * Author li.ling
 * Description lc 删除排序数组中的重复项 II - 双指针
 * Date 2021/3/21 17:52
 */
public class Solution12 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int j = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j] = nums[i+1];
                j++;
            }
        }
        return j;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 1;
        int count = 1;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        Solution12 solution12 = new Solution12();
        int i = solution12.removeDuplicates(nums);
        System.out.println(i);
    }
}
