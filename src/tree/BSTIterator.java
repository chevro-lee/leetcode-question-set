package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author li.ling
 * Description lc 二叉搜索树迭代器
 * Date 2021/4/26 10:07
 */
public class BSTIterator {

    private TreeNode curr;

    private Deque<TreeNode> stack;


    public BSTIterator(TreeNode root) {
        this.curr = root;
        this.stack = new LinkedList<>();
    }

    public int next() {
        // 中序遍历维护栈
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        int res = curr.val;
        curr = curr.right;
        return res;
    }

    public boolean hasNext() {
        return curr != null || !stack.isEmpty();
    }


}
