package Google;

import sun.security.x509.EDIPartyName;

import javax.swing.text.EditorKit;

public class Remove_Redundant {
    public int[] findRedundantConnection(int[][] edges) {
        // Edge
        if (edges == null || edges.length == 0) return null;
        // Init
        int[] ret = new int[2];
        int[] roots = new int[edges.length];
        for (int i  = 0; i < roots.length; i++) {
            roots[i] = i;
        }

        // Loop
        for (int[] edge : edges) {
            int startNode = edge[0];
            int endNode = edge[1];

            if (findRoot(roots, startNode) == findRoot(roots, endNode)) {
                return edge;
            }
            else {
                roots[findRoot(roots, startNode)] = findRoot(roots, endNode);
            }
        }

        return null;

    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // Edge
        if (edges == null || edges.length == 0) return new int[2];
        // Init
        int[] roots = new int[edges.length];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }

        int[] cand1 = null;
        int[] cand2 = null;

        // Try to find 2 indegree nodes
        for (int[] edge : edges) {
            int startNode = edge[0];
            int endNode = edge[1];

            if (roots[endNode] == endNode) {
                roots[endNode] = startNode;
            }
            else {
                cand1 = new int[] {roots[endNode], endNode};
                cand2 = edge;
                break;
            }
        }

        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }

        for (int[] edge : edges) {
            int startNode = edge[0];
            int endNode = edge[1];
            int root1 = findRoot(roots, startNode);
            int root2 = findRoot(roots, endNode);

            if (root1 == root2) {
                if (cand1 == null) return edge;
                return cand1;
            }
            else {
                roots[root2] = root1;
            }
        }

        return cand2;
    }


    private int findRoot(int[] roots, int index) {
        while (index != roots[index]) {
            index = roots[index];
        }
        return index;
    }
}
