package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author li.ling
 * Description 113 路径总和Ⅱ
 * Date 2021/4/20 16:16
 */
public class Solution7 {

    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> stack = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        // 每次递归往栈里添加一个元素
        stack.offerLast(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            // 找到等于目标和的叶子节点，让该路径添加到结果集
            res.add(new LinkedList<>(stack));
        }
        pathSum(root.left, targetSum - root.val);
        pathSum(root.right, targetSum - root.val);
        // 回溯，每次递归完成弹出最上面的元素
        stack.pollLast();
        return res;
    }

}
