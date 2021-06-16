package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author li.ling
 * Description lc 对称二叉树 同剑指offer 28 对称的二叉树 未提交
 * Date 2021/4/19 17:34
 */
public class Solution5 {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirrorHelper(root.left, root.right);
    }

    public boolean isMirrorHelper(TreeNode left, TreeNode right) {
        // 如果左右两个节点都为叶子节点
        if (left == null && right == null) {
            return true;
        }
        // 如果左右两个节点其中有一个为空，或是两者不相等
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        // 判断左节点的左子节点和右节点的右子节点，以及左节点的右子节点和右节点的左子节点是否相等
        return isMirrorHelper(left.left, right.right) && isMirrorHelper(left.right, right.left);
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode p1 = root.left;
        TreeNode p2 = root.right;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || p1 != null || p2 != null) {
            while (p1 != null && p2 != null) {
                if (p1.val != p2.val) {
                    return false;
                }
                stack.push(p1);
                stack.push(p2);
                p1 = p1.left;
                p2 = p2.right;
            }
            // 遍历到了空节点，从栈中弹出父节点
            if (p1 == null && p2 == null) {
                p2 = stack.pop();
                p1 = stack.pop();
                // 由于p1最开始从左边开始遍历，p2最开始从右边开始遍历
                p1 = p1.right;
                p2 = p2.left;
            } else {
                // 两者不同时为空，则不是对称二叉树
                return false;
            }
        }
        return true;
    }
}
