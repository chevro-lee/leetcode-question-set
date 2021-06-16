package tree;


import java.util.Deque;
import java.util.LinkedList;

/**
 * Author li.ling
 * Description 437. 路径总和 Ⅲ
 * Date 2021/4/20 18:10
 */
public class Solution8 {

    private int count;
    private Deque<Integer> stack = new LinkedList<>();

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        stack.offerLast(root.val);
        if (targetSum == root.val) {
            count++;
        }
        pathSum(root.left, targetSum - root.val);
        pathSum(root.right, targetSum - root.val);
        stack.pollLast();
        return count;
    }
}
