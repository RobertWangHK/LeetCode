package Facebook;

import Utils.TreeNode;

public class LC_404_Sum_Left_Leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    /**
     * 1. leaf; 2. left leaf;
     * If already at the node, can determine if it is leaf, but cannot
     * decide if left or right leaf.
     * So should determine left leaf or not at its parent node
     *
     * if node's left child is not leaf, just collect its value, combine
     * with right child's traversal value and return.
     *
     * This thinking of temporarily collect ret value is common and should
     * be easy.
     *
     * @param root parent node
     * @return collective value of sum of left leaves
     */
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftSum = 0;
        int rightSum = 0;
        if (root.left != null && root.left.left == null
                && root.left.right == null) {
            leftSum += root.left.val;
        }
        else {
            leftSum = dfs(root.left);
        }
        rightSum = dfs(root.right);
        return leftSum + rightSum;
    }
}
