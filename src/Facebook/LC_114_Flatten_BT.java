package Facebook;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val) {this.val = val;}
}

public class LC_114_Flatten_BT {

    public void flatten(TreeNode root) {
        // Edge
        if (root == null) return;
        helper(root);
    }

    // Helper function that returns the last element on each subtree
    private TreeNode helper(TreeNode root) {
        // Edge
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        // Divide
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);

        // Combine
        if (left != null) {
            TreeNode rightTmp = root.right;
            root.right = root.left;
            left.right = rightTmp;
        }

        if (right != null) {
            root.left = null;
            return right;
        }

        root.left = null;
        return left;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.right = node6;
        LC_114_Flatten_BT lc = new LC_114_Flatten_BT();
        lc.flatten(node1);

    }

}
