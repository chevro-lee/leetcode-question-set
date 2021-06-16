package arrays;

/**
 * Author li.ling
 * Description lc 旋转图像
 * Date 2021/3/31 15:00
 */
public class Solution30 {

    // 先上下交换，后对角线交换
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        // 上下行交换
        for (int i = 0; i < len / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[len - i - 1];
            matrix[len - i - 1] = temp;
        }
        // 对角线交换
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
