package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Author li.ling
 * Description lc 二叉搜索迭代器
 * Date 2021/4/26 15:16
 */
public class BSTIterator2 {

    private int index;

    private List<Integer> list;



    public BSTIterator2(TreeNode root) {
        this.index = 0;
        this.list = new ArrayList<>();
        inorderTraverse(root);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }

    private void inorderTraverse (TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        list.add(root.val);
        inorderTraverse(root.right);
    }
}
