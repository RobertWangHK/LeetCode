package Facebook;

import Utils.TreeNode;

/**
 * The key idea of this problem is to set proper restrictions on the methods,
 * namely divide the problem scope in two separate portions.
 */
public class LC_572_Subtree_Of_Another {

    // Check if contains, remember t should be kept complete during recursion
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (helper(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // Check if equals
    private boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;
        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}
