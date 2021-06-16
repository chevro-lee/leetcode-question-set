package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Author li.ling
 * Description lc 二叉树的中序遍历
 * Date 2021/4/15 18:11
 */
public class Solution1 {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }
        helper(treeNode.left, res);
        res.add(treeNode.val);
        helper(treeNode.right, res);
    }


    /**
     * 迭代 - 深度优先
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            // 遍历到当前节点不等于null，入栈，变更指向root的指针指向root.left，
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 如果当前节点等于null，父节点出栈，父节点存入res，并将指针指向root的右节点
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * 迭代 - 广度优先搜索
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        // 压入第一个节点
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t.left == null) {
                res.add(t.val);
            }
            if (t.right != null) {
                stack.push(t.right);
            }
            if (t.left != null) {
                stack.push(t);
                stack.push(t.left);
            }
        }
        return res;
    }

    /**
     * Morris 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        // 当前节点为空，表示节点数树已经遍历完成
        while (cur != null) {
            // 一直向左，直到找到最左边的子节点
            if (cur.left == null) {
                res.add(cur.val);
                // 当遍历到最左边的孩子节点，通过pre指针指向原来位置的cur回到原来父节点位置，开始往右边寻找节点
                cur = cur.right;
            } else {
                // 如果当前节点不为空的左子节点不为空，则从右边开始找
                TreeNode pre = cur.left;
                // 找到当前节点最右边的节点
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                // 找到当前节点cur最右边的节点之后，将pre的右孩子指针指向cur，同时cur继续向左移动
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    // 如果pre.right != null，那么这里pre.right肯定等于cur的位置了，所以这里需要去掉pre.right的指针指向
                    // 以及向res中添加此时处于根节点位置的cur，以及向根节点cur的右孩子节点开始遍历
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

}
