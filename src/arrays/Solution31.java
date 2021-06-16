package arrays;

/**
 * Author li.ling
 * Description lc 寻找数据的中心索引
 * Date 2021/4/2 19:44
 */
public class Solution31 {

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sumL = 0;
        int sumR = 0;
        for (int num : nums) {
            sumR += num;
        }
        // 如果总数等于第一个数，第一个数的下标就是中心索引
        if (sumR - nums[0] == 0) {
            return 0;
        }
        // 否则，从左边开始，依次减去sumR，加到sumL，若相等即为中心索引
        for (int i = 0; i < nums.length; i++) {
            if (sumL == sumR - nums[i]) {
                return i;
            }
            sumL += nums[i];
            sumR -= nums[i];
        }
        return -1;
    }
}
