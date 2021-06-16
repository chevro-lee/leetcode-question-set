package tree;

/**
 * Author li.ling
 * Description lc 二叉树的最大深度
 * Date 2021/4/19 17:06
 */
public class Solution4 {

    private int res;

    /**
     * 自顶向下 - 也是前序遍历求二叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int depth = 1;
        return helper(root, depth);
    }

    public int helper(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
        return res;
    }

    /**
     * 自底向下，也是后序遍历
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depthLeft = maxDepth1(root.left);
        int depthRight = maxDepth1(root.right);
        return Math.max(depthLeft, depthRight) + 1;
    }
}
