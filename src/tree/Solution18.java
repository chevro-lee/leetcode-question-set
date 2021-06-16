package tree;

/**
 * Author li.ling
 * Description lc 删除二叉搜索树中的节点
 * Date 2021/6/1 17:45
 */
public class Solution18 {

    public TreeNode deleteNode(TreeNode root, int key) {
        // 递归退出条件
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            // 如果当前节点大于要删除的节点值，则继续往左子树查找
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // 如果当前节点小于要删除的节点值，则继续往右子树中查找
            root.right = deleteNode(root.right, key);
        } else {
            // 如果等于，则找到了要删除的节点
            if (root.left == null && root.right == null) {
                // 如果当前节点没有子节点，则直接删除
                root = null;
            } else if (root.right != null) {
                // 如果存在右子树，则找到右子树的最小值替换，替换之后，直接删除替换的值就行，无需改变树结构
                root.val = findRightMin(root);
                // 由于原值被右子树最小值替换了，找到右子树最小值加以删除
                root.right = deleteNode(root.right, root.val);
            } else {
                // 如果只有左子树，则找到左子树的最大值替换
                root.val = finaLeftMax(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    private int findRightMin(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    private int finaLeftMax(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
