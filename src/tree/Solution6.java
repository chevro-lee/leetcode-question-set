package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author li.ling
 * Description lc 路径总和
 * Date 2021/4/20 11:12
 */
public class Solution6 {

    /**
     * 递归
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            // 递归到了叶子节点，判断叶子节点的值和逐层递减目标值是否相等
            // 相等即说明存在这样的结果
            return root.val == targetSum;
        }
        // 分别沿着左子节点和右子节点递归，同时减去当前节点的值，直到遍历到的叶子节点
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     * 层序遍历（bfs） 求 路径总和
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 每个节点的值更新为targetSum当前节点值的之后的值,如果最后的叶子节点的值为0，则说明找到了路径
        root.val = targetSum - root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 出队列
                TreeNode node = queue.poll();
                // 遍历到了叶子节点
                if (node.left == null && node.right == null && node.val == 0) {
                    return true;
                }
                // 分别将左右两个子节点加入队列中
                if (node.left != null) {
                    node.left.val = node.val - node.left.val;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val - node.right.val;
                    queue.add(node.right);
                }
            }
        }
        // 遍历完了整颗树都没找到和为targetSum的路径
        return false;
    }
}
