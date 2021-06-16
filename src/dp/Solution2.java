package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Author li.ling
 * Description 322. 零钱兑换
 * Date 2021/4/8 10:07
 */
public class Solution2 {

    /**
     * 加备忘录的递归方法 - 动态规划（递归二叉树自顶向下）
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        return findWay(coins, amount, map);
    }

    public int findWay(int[] coins, int amount, Map<Integer, Integer> map) {
        // 递归退出条件
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
           return 0;
        }
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
           // 子问题：求解减去当前硬币数量的amount的金额所需花费的最小最少硬币个数
           int resTemp = findWay(coins, amount - coin, map);
           // 当前情况下所需的硬币更少，更新res的值
           if (resTemp >= 0 && resTemp < res) {
               // 得到resTemp结果，需要的一个硬币
               res = resTemp + 1;
           }
        }
        map.put(amount, res == Integer.MAX_VALUE ? -1 : res);
        return map.get(amount);
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 50;
        Solution2 solution2 = new Solution2();
        int i = solution2.coinChange(coins, amount);
        System.out.println(i);
    }
}
