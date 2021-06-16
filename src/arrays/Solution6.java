package arrays;

/**
 * Author li.ling
 * Description 628. 三个数的最大乘积 - 线性扫描法  找出第一、二小的数，第一，二，三大的数
 * 存在含有负数的情况，所以需要找出最小的两个数
 * Date 2021/3/6 18:32
 */
public class Solution6 {


    public int maximumProduct(int[] nums) {
        // 最小的数
        int min1 = Integer.MAX_VALUE;
        // 第二小的数
        int min2 = Integer.MAX_VALUE;
        // 第三大的数
        int max1 = Integer.MIN_VALUE;
        // 第二大的数
        int max2 = Integer.MIN_VALUE;
        // 第一大的数
        int max3 = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
            if (x > max3) {
                max1 = max2;
                max2 = max3;
                max3 = x;
            } else if (x > max2) {
                max1 = max2;
                max2 = x;
            } else if (x > max1) {
                max1 = x;
            }
        }
        return Math.max(min1 * min2 * max3, max1 * max2 * max3);
    }
}