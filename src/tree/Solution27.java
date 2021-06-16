package tree;

/**
 * Author li.ling
 * Description 226.翻转二叉树 同 剑指 Offer 27. 二叉树的镜像 未提交
 * Date 2021/6/10 16:42
 */
public class Solution27 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
