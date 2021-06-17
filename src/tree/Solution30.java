package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author li.ling
 * Description 404.左叶子之和 LL
 * Date 2021/6/12 15:19
 */
public class Solution30 {

    public int sumOfLeftLeaves(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }

    /**
     * 深度优先搜索
     *
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        int ans = 0;
        // 判断当前节点的左边
        if (root.left != null) {
            // 如果当前节点的左孩子节点是叶子节点，则将左孩子节点累加，否则继续递归查找左叶子节点
            ans += isLeafNode(root.left) ? root.left.val : dfs(root.left);
        }
        // 判断当前节点右边,如果当前孩子的右孩子节点为叶子节点，没必要继续找左叶子节点了
        if (root.right != null && !isLeafNode(root.right)) {
            // 右边找左叶子节点的值累加
            ans += dfs(root.right);
        }
        return ans;
    }

    /**
     * 广度优先搜索
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    // 满足是左叶子节点将值累加
                    ans += node.left.val;
                } else {
                    // 否则将节点的左子节点加入队列，等待下一个循环的判断
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                // 将非叶子节点的右节点加入队列，等待下一次循环判断右子节点是否有左子节点
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }


}
