package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Author li.ling
 * Description lc 二叉搜索树的最近公共祖先
 * Date 2021/6/4 14:26
 */
public class Solution19 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果没有找到，或是找到了p，或者q
        if (root == null || root == p || root == q) {
            return root;
        }
        // 找左子树
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        // 找右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左子树和右子树都找到了，说明当前的根结点root是他们的最近的公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 如果左边或是右边某一边没有找到，说明在同左或是同右侧，则左边或是右边的递归结果为最近的公共祖先
        return left == null ? right : left;
    }

    /**
     * 利用二叉搜索树的性质，如果p比root大，则root向右子树移动，如果p比root小，则root向左子树移动
     * q同理，同时保存root到p以及q的路径，深度最大的相同的路径结点即为两点最近的公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = getPath(root, p);
        List<TreeNode> pathQ = getPath(root, q);
        TreeNode ancestor = null;
        // 寻找两个结点深度最大的公共子结点
        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                ancestor = pathP.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target){
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        // 寻找到指定target的路径信息
        while (node != target) {
            path.add(node);
            if (node.val < target.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        // 最后将相等的结点加 入路径path中
        path.add(node);
        return path;
    }

    /**
     * 遍历一次，如果当前节点比p和q大，则往左子树移动，如果当前节点比p和q小，往右子树移动，否则当且节点即遍历到了两个节点的
     * 分叉处。如果p或者q在同一侧，那么当前节点即遍历到了p或者q处，此处即为两者的最近公共节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            // 如果节点比p和q都大
            if (ancestor.val > p.val && ancestor.val > q.val) {
                ancestor = ancestor.left;
            } else if (ancestor.val < p.val && ancestor.val < q.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
