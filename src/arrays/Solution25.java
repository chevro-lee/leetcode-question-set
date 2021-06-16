package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Author li.ling
 * Description lc 存在重复元素
 * Date 2021/3/29 15:40
 */
public class Solution25 {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null  || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
