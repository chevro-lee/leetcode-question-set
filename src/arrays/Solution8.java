package arrays;

/**
 * Author li.ling
 * Description 1672. 最富有客户的资产总量
 * Date 2021/3/7 16:21
 */
public class Solution8 {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 1; j < accounts[0].length; j++) {
                accounts[i][0] += accounts[i][j];
            }
            if (max < accounts[i][0]) {
                max = accounts[i][0];
            }
        }
        return max;
    }
}
