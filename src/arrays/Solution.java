package arrays;

/**
 * Author li.ling
 * Description 867. 转置矩阵
 * Date 2021/3/3 15:51
 */
public class Solution {

    int[][] matrix = {{2, 4, -1}, {-10, 5, 11}};

    public int[][] transpose(int[][] matrix) {
        // 2行
        int row = matrix.length;
        // 3列
        int col = matrix[0].length;
        int[][] transpose = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transpose[j][i] = matrix[i][j];
            }
            System.out.println();
        }
        return transpose;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.transpose(solution.matrix);
    }
}
