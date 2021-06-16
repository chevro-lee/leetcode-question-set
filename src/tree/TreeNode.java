package tree;

/**
 * Author li.ling
 * Description
 * Date 2021/4/15 11:16
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode build(String[] vals) {
        TreeNode root = new TreeNode();
        if (vals == null || vals.length == 0) {
            root = null;
        } else {
            int intVal;
            for (String val : vals) {
                if (val.equals("null")) {
                    continue;
                }
                intVal = Integer.parseInt(val);
                root = insertIntoBST(root, intVal);
            }
        }
        return root;
    }

    private TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

}
