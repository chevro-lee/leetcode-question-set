package tree;

/**
 * Author li.ling
 * Description 108.数组转化为二叉树
 * Date 2021/6/4 17:39
 */
public class Solution20 {



    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    // 由于题目要求是高度平衡二叉树，所以每次选取数组的中间的数作为根结点
    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        // 计算中间节点
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 递归构建左右子树
        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);
        return root;
    }
}
