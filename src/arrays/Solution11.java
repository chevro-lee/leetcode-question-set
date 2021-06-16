package arrays;

/**
 * Author li.ling
 * Description 26. 删除有序数组中的重复项
 * Date 2021/3/20 23:53
 */
public class Solution11 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        Solution11 solution11 = new Solution11();
        int i = solution11.removeDuplicates(nums);
        System.out.println(i);
    }
}
