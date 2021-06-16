package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Author li.ling
 * Description 118.杨辉三角
 * Date 2021/6/3 18:18
 */
public class Solution33 {

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return null;
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 杨辉三角边缘的元素都为1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // 等于上一层两个元素相加
                    int sum = ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j);
                    row.add(sum);
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
