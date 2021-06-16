package arrays;

/**
 * Author li.ling
 * Description 1476. 子矩形查询
 * Date 2021/3/5 9:20
 */
public class SubrectangleQueries {

    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }

    public static void main(String[] args) {
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}});
        subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
        int a = subrectangleQueries.getValue(2, 2);
        System.out.println(a);
    }
}
