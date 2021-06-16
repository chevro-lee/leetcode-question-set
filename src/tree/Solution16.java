package tree;

/**
 * Author li.ling
 * Description lc 二叉搜索树中的搜索
 * Date 2021/4/26 9:54
 */
public class Solution16 {


    /**
     * 递归
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    /**
     * 迭代
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null && val != root.val) {
             root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
