package tree;

/**
 * Author li.ling
 * Description 104.二叉树的最大的深度 同剑指 Offer 55 - I. 二叉树的深度
 * Date 2021/6/9 15:54
 */
public class Solution23 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子树的最大深度
        int left = maxDepth(root.left);
        // 右子树的最大深度
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"3","9","20","null","null","15","7"};
        TreeNode root = new TreeNode().build(strs);
        Solution23 solution23 = new Solution23();
        int i = solution23.maxDepth(root);
        System.out.println(i);
    }
}
