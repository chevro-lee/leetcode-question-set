package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Author li.ling
 * Description lc 从中序和后序遍历序列构造二叉树
 * Date 2021/4/21 17:40
 */
public class Solution11 {

    private int[] inorder;

    private int[] preorder;

    private int preIdx;

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        int index = 0;
        for (int inorderVal : inorder) {
            map.put(inorderVal, index);
            index++;
        }
        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int index = map.get(preorder[preIdx]);
        int rootVal = inorder[index];
        TreeNode root = new TreeNode(rootVal);
        preIdx++;
        root.left = helper(left, index - 1);
        root.right = helper(index + 1, right);
        return root;
    }

}
