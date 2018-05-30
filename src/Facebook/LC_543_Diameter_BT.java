package Facebook;

import Utils.TreeNode;

public class LC_543_Diameter_BT {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxPath(root);
        return diameter;
    }

    // return maximum path length from this node to one of its leaves
    private int maxPath(TreeNode node) {
        if (node == null) return 0;
        int leftMax = maxPath(node.left);
        int rightMax = maxPath(node.right);
        diameter = Math.max(diameter, leftMax + rightMax);
        return Math.max(leftMax, rightMax) + 1;
    }
}
