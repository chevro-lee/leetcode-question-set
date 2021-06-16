package dp;

import java.util.Arrays;

/**
 * Author li.ling
 * Description 322. 零钱兑换
 * Date 2021/4/14 15:30
 */
public class Solution3 {

    /**
     * DP数组，动态规划，自低向上
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // dp数组存储每个子问题的金额的最优硬币组成个数
        // 初始化dp数据的长度为amount + 1，最大的情况为每个1块的硬币组成amount
        int[] dp = new int[amount + 1];
        // 将dp数组每个元素填充为可取的最大值，方便后续取最小值替换
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                // 当前子问题的金额无解
                if (i - coin < 0) {
                    continue;
                }
                // 转移方程：dp[i-coin]+1
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 50;
        Solution3 solution3 = new Solution3();
        int i = solution3.coinChange(coins, amount);
        System.out.println(i);
    }
}
