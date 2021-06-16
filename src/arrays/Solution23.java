package arrays;

/**
 * Author li.ling
 * Description lc 122. 买卖股票的最佳时机 II
 * Date 2021/3/26 18:07
 */
public class Solution23 {

    // 贪心算法解题，当天卖，当天买，只要今天卖出能赚就卖
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] > 0) {
                ans += prices[i] - prices[i-1];
            }
        }
        return ans;
    }
}
