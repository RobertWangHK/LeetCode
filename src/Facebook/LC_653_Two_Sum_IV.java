package Facebook;

import Utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LC_653_Two_Sum_IV {
    Set<Integer> visited = new HashSet<>();
    // If don't care about space usage
    public boolean findTarget(TreeNode root, int k) {
        if (root == null ) {
            return false;
        }
        return helper(root, k);
    }

    /**
     * Figure if target - curr.val is visited
     * @param node current node
     * @param target target value
     * @return if or not target - current node's value is visited before
     */
    private boolean helper(TreeNode node, int target) {
        if (node == null) return false;
        if (visited.contains(target - node.val)) return true;
        visited.add(node.val);
        return helper(node.left, target) || helper(node.right, target);
    }

}
