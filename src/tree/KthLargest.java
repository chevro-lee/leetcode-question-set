package tree;

/**
 * Author li.ling
 * Description lc 数据流中第K大元素
 * Date 2021/6/2 14:31
 */
public class KthLargest {

    private class BST {

        private class TreeNode {

            private int val;

            // 相同节点不插入二叉搜索树，用此变量记录，由于包含自己，所以默认为1
            private int count = 1;

            private TreeNode left;
            private TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        private TreeNode root;

        public void add(int val) {
            root = add(root, val);
        }

        private TreeNode add(TreeNode node, int val) {
            if (node == null) {
                return new TreeNode(val);
            }
            if (node.val > val) {
                node.left = add(node.left, val);
            } else if (node.val < val) {
                node.right = add(node.right, val);
            }
            // 如果当前值与待插入的值相同，不插入，count++
            node.count++;
            return node;
        }

        public TreeNode search(int k) {
            return search(root, k);
        }

        private TreeNode search(TreeNode node, int k) {
            if (node == null) {
                return node;
            }
            int leftNodeCount = node.left != null ? node.left.count : 0;
            int rightNodeCount = node.right != null ? node.right.count : 0;
            int currNodeCount = node.count - leftNodeCount - rightNodeCount;
            if (k > currNodeCount + rightNodeCount) {
                // 如果k > 当前结点数加上右子树的结点数，则搜索左子树
                return search(node.left, k - currNodeCount - rightNodeCount);
            } else if (k <= rightNodeCount) {
                // 如果k <= 右子树的结点数，则搜索右子树
                return search(node.right, k);
            } else {
                // k == 当前结点数加右子树的结点数，则找到第k大的结点
                return node;
            }
        }
    }

    private int k;
    private BST bst = new BST();


    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (Integer num : nums) {
            bst.add(num);
        }
    }

    public int add(int val) {
        bst.add(val);
        return bst.search(k).val;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,8,2};
        KthLargest kthLargest = new KthLargest(3,arr);
        int add3 = kthLargest.add(3);
        System.out.println(add3);
    }
}
