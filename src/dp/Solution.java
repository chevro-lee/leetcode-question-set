package dp;

import java.util.HashMap;
import java.util.Map;


/**
 * Author li.ling
 * Description 剑指 Offer 10- I. 斐波那契数列
 * Date 2021/4/4 17:19
 */
public class Solution {

    /**
     * 迭代 - 备忘录 (动态规划-自顶向下)
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n < 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        return helper(n, map);
    }

    public int helper(int n, Map<Integer, Integer> map) {
        if (n == 1 || n == 2) {
            return 1;
        }
        // 已经计算过
        if (map.containsKey(n)) {
            System.out.println("n:" + n);
            return map.get(n);
        }
        int value = (helper(n - 1, map) + helper(n - 2, map)) % 1000000007;
        System.out.println("n=="+n);
        // 存入备忘录，避免下次重复计算
        map.put(n, value);
        return value;
    }

    /**
     * dp数组 - 自低向上
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n == 2 || n == 1) {
            return 1;
        }
        int prev = 1;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum % 1000000007;
        }
        return curr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int fib = solution.fib(19);
        System.out.println(fib);
    }
}
