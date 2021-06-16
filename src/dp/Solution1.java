package dp;


/**
 * Author li.ling
 * Description 322. 零钱兑换
 * Date 2021/4/4 20:18
 */
public class Solution1 {

    private int res = Integer.MAX_VALUE;

    /**
     * 暴力递归解法 - 使用递归时间复杂度为指数级，超出leetcode时间限制
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        findWay(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void findWay(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
        }
        for (int coin : coins) {
            findWay(coins, amount - coin, count + 1);
        }
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        Solution1 solution1 = new Solution1();
        int i = solution1.coinChange(coins, amount);
        System.out.println(i);
    }
}
