package Facebook;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_637_Ave_Level {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> retList = new LinkedList<>();
        if (root == null) return retList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Traverse Level by Level of the tree
        while (!queue.isEmpty()) {
            double sum = 0.0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currTreeNode = queue.poll();
                sum += currTreeNode.val;
                if (currTreeNode.left != null) {
                    queue.offer(currTreeNode.left);
                }
                if (currTreeNode.right != null) {
                    queue.offer(currTreeNode.right);
                }
            }
            retList.add(sum / size);
        }

        return retList;
    }

}
