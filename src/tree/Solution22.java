package tree;


/**
 * Author li.ling
 * Description lc 平衡二叉树
 * Date 2021/6/9 10:28
 */
public class Solution22 {

    /**
     * 自顶向下的递归, 空间复杂度取决于递归的层数，递归的层数最多不会超过二叉搜索的节点数，因此为O(n)
     * 时间复杂度在最坏的情况下，二叉树退化成一条链表，此时的高度为n，因此总时间复杂度为O（n^2）
     * 在一般情况下二叉树的高度为logn,因此总时间复杂度为O（nlogn）
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左右子树的高度之差小于等于1，并且左右子树皆是平衡二叉树
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // 递归求解当前节点的最大高度
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    /**
     * 自低向下 时间复杂度，由于是自低向上的
     *
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        // 只要递归结果没有返回-1，说明这颗树是平衡二叉树
        return height1(root) >= 0;
    }

    private int height1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 类似后序遍历，先判断左右子树是否是平衡二叉树，而后判断当前节点的左右子树的高度差是否小于等于-1
        int leftHeight = height1(root.left);
        int rightHeight = height1(root.right);
        // 递归判断左右子树是否是平衡的,以及左右子树的高度差是否小于等于1
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    public static void main(String[] args) {
        String[] arr = new String[]{"3","9","20","null","null","15","7"};
        TreeNode root = new TreeNode().build(arr);
        Solution22 solution22 = new Solution22();
        boolean balanced = solution22.isBalanced(root);
        System.out.println(balanced);
    }
}
