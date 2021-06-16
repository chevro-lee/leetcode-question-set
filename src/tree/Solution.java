package tree;


import java.util.*;

/**
 * Author li.ling
 * Description lc 二叉树的前序遍历
 * Date 2021/4/15 11:12
 */
public class Solution {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        // 先添加，后递归，保证根节点第一个被加入其中
        list.add(treeNode.val);
        helper(treeNode.left, list);
        helper(treeNode.right, list);
    }

    /**
     * 迭代 - 深度优先
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        // 遍历一个元素，往栈里存一个元素，同时将当前节点指向左子节点
        // 如果栈里还有节点，或是树当前指向的节点不为空，则继续遍历树
        while (!stack.isEmpty() || root != null) {
            // 如果当前节点的指向不为空
            while (root != null) {
                // 遍历到的元素加入res中
                res.add(root.val);
                // 入栈，为之后遍历到空节点做准备，如果为空节点，则出栈，以此节点找到右孩子节点
                stack.push(root);
                root = root.left;
            }
            // 如果当前节点的指向为空，说明此时遍历到了空的孩子节点，从栈里弹出元素，并指向取出元素的右节点
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

    /**
     * 迭代 - 广度优先
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 入栈第一个节点
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            // 弹出的元素即为遍历到的元素
            res.add(t.val);
            // 如果有右孩子节点，先入栈，保证遍历顺序是前序遍历
            if (t.right != null) {
                stack.push(t.right);
            }
            if (t.left != null) {
                stack.push(t.left);
            }
        }
        return res;
    }

    /**
     * Morris 前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        while (cur != null) {
            // 遍历到了最左边的子节点，由于是前序遍历，根左右，所以先加入res结果集
            if (cur.left == null) {
                res.add(cur.val);
                // 后指向通过pre指针指向原来父节点的cur，这个cur去遍历右边的节点
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                // 找了prev节点最右边的节点
                if (prev.right == null) {
                    // 将prev.right 指向cur，方便回溯
                    prev.right = cur;
                    // 添加此时cur的位置进入res结果集
                    res.add(cur.val);
                    // 由于此时cur还有左孩子节点，所以cur继续往左边移动
                    cur = cur.left;
                } else {
                    // 这里的情况肯定是prev.right == cur了
                    cur = cur.right;
                    prev.right = null;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        Solution solution = new Solution();
        List<Integer> list = solution.preorderTraversal1(treeNode);
        System.out.println(list);
    }
}
