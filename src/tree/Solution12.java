package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author li.ling
 * Description
 * Date 2021/4/21 23:03
 */
public class Solution12 {

    /**
     * BFS 层序遍历解法
     *
     * @param root
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 弹出链表头部元素并删除
                Node node = queue.poll();
                // 如果遍历的当层元素的节点未到当层的最右边的节点，则将当前节点连接到与他相邻的右边节点
                if (i < size - 1) {
                    // peek()弹出元素但是不删除
                    node.next = queue.peek();
                }
                // 扩展下一层元素
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    /**
     * DFS 递归
     *
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root.left, root.right);
        return root;
    }

    private void dfs(Node left, Node right) {
        if (left == null || left.next == right) {
            return;
        }
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }


}
