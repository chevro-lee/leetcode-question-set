package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Author li.ling
 * Description  228. 汇总区间 - 双指针法
 * Date 2021/3/6 14:38
 */
public class Solution5 {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int len = nums.length;
        for (int j = 0; j < len; j++) {
            if (j + 1 == len || nums[j] + 1 != nums[j + 1]) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                if (i != j) {
                    sb.append("->").append(nums[j]);
                }
                result.add(sb.toString());
                i = j + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.summaryRanges(new int[]{-2147483648, -2147483647, 2147483647}));
    }
}
