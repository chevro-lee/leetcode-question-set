package arrays;

/**
 * Author li.ling
 * Description lc 买卖股票的最佳时机 - 动态规划
 * Date 2021/3/26 16:58
 */
public class Solution22 {

    // 动态规划解题
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 1.记录之前最便宜的股票
        int min = prices[0];
        // 2.计算之前最小值买入，今天卖出的最大获利情况
        int max = 0;
        // 3.迭代找出最大的获利利润
        for (int price : prices) {
            max = Math.max(max, price - min);
            min = Math.min(min, price);
        }
        return max;
    }

    // 双指针
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int currProfit = 0;
        for (int i = 0, j = 0; j < prices.length; j++) {
            if (prices[j] - prices[i] < 0) {
                i = j;
            } else {
                currProfit = Math.max(currProfit, prices[j] - prices[i]);
            }
        }
        return currProfit;
    }
}
