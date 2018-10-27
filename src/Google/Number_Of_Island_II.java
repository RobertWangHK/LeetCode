package Google;

import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

public class Number_Of_Island_II {
    private final int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        // Edge
        if (positions == null || positions.length == 0 || positions[0].length == 0) {
            return new LinkedList<Integer>();
        }
        // Init
        List<Integer> retList = new LinkedList<>();
        int[] parents = new int[m * n];
        Arrays.fill(parents, -1);
        int count = 0;

        for (int[] pos : positions) {
            int x = pos[0];
            int y = pos[1];
            parents[x * n + y] = x * n + y;
            count += 1;
            for (int i = 0; i < 4; i++) {
                int newX = x + dirs[i][0];
                int newY = y + dirs[i][1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n)
                    continue;
                if (parents[newX * n + newY] == -1)
                    continue;
                int oldParent = find(parents, newX * n + newY);
                if (oldParent == x * n + y)
                    continue;
                parents[oldParent] = x * n + y;
                count -= 1;
            }
            retList.add(count);
        }

        return retList;
    }

    // Helper find function
    private int find(int[] parents, int index) {
        while (parents[index] != index) {
            index = parents[index];
        }
        return index;
    }
}
