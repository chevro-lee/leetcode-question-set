package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Author li.ling
 * Description lc 从中序和后序遍历序列构造二叉树
 * Date 2021/4/21 15:14
 */
public class Solution10 {

    private int[] inorder;

    private int[] postorder;

    private int postIdx;

    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * 递归
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        // 将中序遍历结果按节点值，索引位置存入hash表中
        int index = 0;
        for (int nodeVal : inorder) {
            map.put(nodeVal, index);
            index++;
        }
        // 后序遍历最后一个节点为二叉树的根节点
        postIdx = postorder.length - 1;
        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        // 递归退出条件，没有节点可以构造二叉树了
        if (left > right) {
            return null;
        }
        // 中序遍历结果集中根节点的位置
        int index = map.get(postorder[postIdx]);
        // 根节点的值
        int rootVal = inorder[index];
        TreeNode root = new TreeNode(rootVal);
        // 向前移动postIdx，继续寻找下一个子二叉树的根节点
        postIdx--;
        // 递归构造右侧子二叉树
        root.right = helper(index + 1, right);
        // 递归构造左侧子二叉树
        root.left = helper(left, index - 1);
        // 返回每层递归空间构造的节点
        return root;
    }
}
