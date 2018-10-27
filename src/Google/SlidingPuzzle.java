package Google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {

    private final int[] d = new int[] {1, -1, -3, 3};

    public int slidingPuzzle(int[][] board) {
        Set<String> visited = new HashSet<>();
        String target = "123456780";

        String init = "";
        for (int i  = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                init += board[i][j];
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(init);
        int distance = 0;

        while (!queue.isEmpty()) {
            distance += 1;
            int size= queue.size();
            for (int i = 0; i < size; i++) {
                String top = queue.poll();
                if (top.equals(target)) return distance;
                int index = top.indexOf('0');
                for (int k = 0; k < 4; k++) {
                    int newIndex = index + d[k];
                    // Invalid position and moves
                    if (newIndex < 0 || newIndex > 8 || (index == 2 && newIndex == 3) || (index == 3 || newIndex == 2)
                        || (index == 5 || newIndex == 6) || (index == 6 || newIndex == 5))
                        continue;
                    // Build now str
                    char[] chars = top.toCharArray();
                    char tmp = chars[index];
                    chars[index] = chars[newIndex];
                    chars[newIndex] = tmp;
                    String newStr = String.valueOf(chars);
                    // If visited
                    if (visited.contains(newStr)) continue;
                    queue.offer(newStr);
                }
            }
        }

        return -1;
    }

}
