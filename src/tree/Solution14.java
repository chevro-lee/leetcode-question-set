package tree;

import java.util.*;

/**
 * Author li.ling
 * Description lc 二叉树的最近公共祖先 同 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * Date 2021/4/22 17:28
 */
public class Solution14 {

    /**
     * BFS 层序遍历 存储父子关系
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // 当前节点作为key，父节点作为value，存储父子关系
        Map<TreeNode, TreeNode> map = new HashMap<>();
        // 根节点没有父节点
        map.put(root, null);
        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 只需遍历到p，q节点即可，不需遍历整颗树
        while(!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                map.put(node.left, node);
            }
            if (node.right != null) {
                queue.add(node.right);
                map.put(node.right, node);
            }
        }
        // 存储p的祖先节点
        Set<TreeNode> ancestors = new HashSet<>();
        // 寻找p的父节点
        while (p != null) {
            ancestors.add(p);
            p = map.get(p);
        }
        // 寻找p的父节点是否同样包含q的父节点
        while (q != null) {
            // 第一次找到包含q的父节点，即为两点最近的公共父节点
            if (ancestors.contains(q)) {
                return q;
            }
            q = map.get(q);
        }
        return null;
    }

    /**
     * 递归
     * 两个节点可能有两种关系 ： 父子关系，兄弟关系
     *  父子关系：两个节点一定同在左子树和右子树中
     *  兄弟关系：两个节点分别在左子树和右子树中
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // 递归退出条件，找到了p或是q，或是没有找到
        if (root == null || root == p || root == q) {
            System.out.println("退出递归层 : " + root);
            return root;
        }
        System.out.println("root.val = "+root.val);
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        System.out.println("left = "+left+"  root = "+root.val);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        System.out.println("right = "+right+"  root = "+root.val);
        // 如果两边都找到了,那么最近的父节点肯定为当前层的根节点
        if (left != null && right  != null) {
            return root;
        }
        // 否则肯定为左边或是右边的查找结果
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6,
                new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        Solution14 solution14 = new Solution14();
        TreeNode p = new TreeNode(4, new TreeNode(3), new TreeNode(5));
        TreeNode q = new TreeNode(5);
        TreeNode node = solution14.lowestCommonAncestor1(root, p, q);
        System.out.println(node);
    }
}
