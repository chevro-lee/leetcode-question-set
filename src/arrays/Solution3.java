package arrays;

/**
 * Author li.ling
 * Description 1535. 找出数组游戏的赢家
 * Date 2021/3/5 11:07
 */
public class Solution3 {

    private static int[] arr = {2,1,3,5,4,6,7};

    public int getWinner(int[] arr, int k) {
        int preMax = Math.max(arr[0], arr[1]);
        int count = 1;
        if (k == count) {
            return preMax;
        }
        for (int i = 2; i < arr.length; i++) {
            if (preMax > arr[i]) {
                count ++;
                if (count == k) {
                    return preMax;
                }
            } else {
                count = 1;
                preMax = arr[i];
            }
            if (i == arr.length - 1) {
                return Math.max(preMax, arr[i]);
            }
        }
        return preMax;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int winner = solution3.getWinner(arr, 3);
        System.out.println(winner);
    }
}
