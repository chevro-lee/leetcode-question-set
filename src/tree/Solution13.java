package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author li.ling
 * Description lc 填充每个节点的下一个右侧节点指针 II
 * Date 2021/4/22 11:34
 */
public class Solution13 {

    /**
     * DFS 递归
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root.left, root.right);
        return root;
    }

    private void dfs(Node left, Node right) {
        if (left == null && right == null) {
            return;
        }
        if (left != null) {

        }

    }

    /**
     * BFS 层序遍历
     *
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 前一个节点
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (pre != null) {
                    pre.next = node;
                }
                pre = node;
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
     * BFS 层序遍历 - 将每一层看作链表
     *
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node();
            // 虚拟节点
            Node pre = dummy;
            // 遍历当层节点
            while (cur != null) {
                // 连接
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            // 将cur移动到下一层
            cur = dummy.next;
        }
        return root;
    }
}
