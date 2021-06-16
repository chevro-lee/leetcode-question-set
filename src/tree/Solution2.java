package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author li.ling
 * Description lc 二叉树的后序遍历
 * Date 2021/4/15 19:56
 */
public class Solution2 {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }
        helper(treeNode.left, res);
        helper(treeNode.right, res);
        res.add(treeNode.val);
    }

    /**
     * 迭代 - 深度优先搜索
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        // 用以记录右子节点，往父节点回溯的时候，不仅需要判断右子节点是否为空，而且还需要判断是否有已经加入过res的右子节点
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            // 遍历到当前节点不等于null，入栈，变更指向root的指针指向root.left，
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 如果当前节点等于null，说明没有左子节点了，取出栈中存的节点，开始找有没有右子节点
            root = stack.pop();
            // 如果没有右子节点，并且没有已经加入过的右子节点
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                // 记录当前的节点，便于往上回溯判定父节点是否能加入res结果集中
                prev = root;
                // root置为null，使下一次循环让栈弹出当前节点的父节点
                root = null;
            } else {
                // 有右子节点的情况，将当前节点压入栈中，并且开始将指针指向右子节点
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * Morris 后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        return null;
    }
}
