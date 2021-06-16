package tree;

import java.util.HashMap;

/**
 * Author li.ling
 * Description 257. 二叉树的所有路径
 * Date 2021/4/20 18:31
 */
public class Solution9 {

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 设置路径和符合条件即res+1的前提（0=pathSum-sum）
        map.put(0, 1);
        return helper(root, map, sum, 0);
    }

    private int helper(TreeNode root, HashMap<Integer, Integer> map, int sum, int pathSum) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        // 将当前所在节点的值加到走过的路径值的和中
        pathSum += root.val;
        // 累加上到当前节点为止有多少条路径和符合条件（此处若是pathSum-sum==0,则返回1，在map中若存在当前pathSum-sum对应值
        // 的key则对应value的值则必不为0，为1或大于1，若无此key则返回方法默认值0）
        res += map.getOrDefault(pathSum - sum, 0);
        // 此处是计数到当前节点为止有多少条自上而下的节点路径和等于pathSum，并将其存入map
        //（亦或是更新pathSum对应的路径数，若先前有和值为pathSum的路径则取出其条数先前加上当前的一条）
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        // 往左子树以及右子树依次统计
        // 再加上res-->到当前节点为止可能出现的和值符合pathSum的路径数（统计范围即为头节点到当前节点）
        res = helper(root.left, map, sum, pathSum) + helper(root.right, map, sum, pathSum) + res;
        // 在返回前，将到当前节点为止的和值pathSum的条数计-1，防止影响后面其他未走完路径的统计
        // 由于路径和值只能自上而下，所以在当前节点返回前（节点返回条件为下一节点为空，
        // 即为最后节点或者最后节点返回后遍历完依次往上递归返回，返回意味着pathSum到当前节点已自上而下的累加遍历完）
        map.put(pathSum, map.get(pathSum) - 1);
        return res;
    }
}
