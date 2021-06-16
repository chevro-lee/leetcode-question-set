package tree;

/**
 * Author li.ling
 * Description lc 二叉搜索树中的插入操作
 * Date 2021/4/26 16:45
 */
public class Solution17 {

    /**
     * 递归
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    /**
     * 迭代
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            // 如果小于当前遍历值
            if (val < cur.val) {
                // 一直向左遍历，直到找到空节点，在当前空节点处插入新节点
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = new TreeNode(val);
                    return root;
                }
            } else {
                // 如果大于等于当前节点
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = new TreeNode(val);
                    return root;
                }
            }
        }
    }
}
