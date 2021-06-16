package arrays;

/**
 * Author li.ling
 * Description lc 只出现一次数字 - 异或运算 - a^a=0 / a^0=0
 * Date 2021/3/29 18:32
 */
public class Solution26 {

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i : nums) {
            single ^= i;
        }
        return single;
    }
}
