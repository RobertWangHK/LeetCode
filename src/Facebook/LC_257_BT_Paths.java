package Facebook;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC_257_BT_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> retList = new LinkedList<>();
        dfs(retList, root, "");
        return retList;
    }

    private void dfs(List<String> retList, TreeNode node, String currPath) {
        if (node == null) return;
        currPath = currPath + node.val + "->";
        if (node.left == null && node.right == null) {
            currPath = currPath.substring(0, currPath.length() - 2);
            retList.add(currPath);
        }
        else {
            dfs(retList, node.left, currPath);
            dfs(retList, node.right, currPath);
        }
    }
}
