package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author li.ling
 * Description lc 二叉树的序列化与反序列化
 * Date 2021/4/23 10:43
 */
public class Codec {

    private String res = "";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 如果遍历到了空节点，将空节点序列化为none
        if (root == null) {
            res += "none,";
        } else {
            // 先序遍历
            res += root.val + ",";
            res = serialize(root.left);
            res = serialize(root.right);
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(split));
        return rdeserialize(list);
    }

    private TreeNode rdeserialize (List<String> list) {
        // 递归退出条件
        if (list.get(0).equals("none")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        // 移除当前层递归的元素
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2), new TreeNode(3,
                new TreeNode(4), new TreeNode(5)));
        Codec codec = new Codec();
        String serialize = codec.serialize(treeNode);
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
