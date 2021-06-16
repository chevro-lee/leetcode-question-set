package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author li.ling
 * Description BST 二叉搜索树   lc 验证二叉搜索树
 * Date 2021/4/23 16:18
 */
public class Solution15 {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
    }

    public boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        // 如果当前递归层的节点比它左边的节点小，或是比它右边的节点大则不是一颗二叉搜索树
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    /**
     * 中序遍历 迭代
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        long pre = (long)Integer.MIN_VALUE - 1;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 每次和上次遍历的节点相比，如果比上次的小，则说明不是二叉搜索树
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }
}
