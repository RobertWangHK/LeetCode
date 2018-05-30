package Facebook;

import Utils.TreeNode;

/**
 * Divide and Conquer
 * Assumption: 1. compare reference == no duplications 2. both will exist
 */
public class LC_235_Lowest_Common_Ancestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode leftNode = helper(root.left, p, q);
        TreeNode rightNode = helper(root.right, p, q);

        if (leftNode == null && rightNode == null) return null;
        if (leftNode == null) return rightNode;
        if (rightNode == null) return leftNode;
        return root;
    }
}
