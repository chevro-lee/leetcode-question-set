package arrays;

/**
 * Author li.ling
 * Description 1588. 所有奇数长度子数组的和 - 暴力破解法
 * Date 2021/3/3 17:41
 */
public class Solution1 {

    private static int[] arr = new int[]{1, 4, 2, 5, 3};

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        // i表示奇数数组的元素个数 1，3，5
        for (int i = 1; i <= arr.length; i = i + 2) {
            // j表示子数组的起始下标
            for (int j = 0; j + i <= arr.length; j++) {
                // k表示子数组的具体下标
                for (int k = j; k < j + i; k++) {
                    sum += arr[k];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().sumOddLengthSubarrays(arr));
    }
}
