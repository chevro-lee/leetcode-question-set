package tree;

/**
 * Author li.ling
 * Description 111.二叉树的最小深度
 * Date 2021/6/9 16:11
 */
public class Solution24 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
