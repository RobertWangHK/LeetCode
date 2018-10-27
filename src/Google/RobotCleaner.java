package Google;

import java.util.HashSet;
import java.util.Set;

public class RobotCleaner {
    private final int[][] dirs = new int[][] {{-1, 0}, {0,1}, {1,0}, {0,-1}};
    public void cleanRoom(Robot robot) {
        dfs(robot, new HashSet<String>(), 0, 0, 0);
    }

    private void dfs(Robot robot, Set<String> visited, int x, int y, int direction) {
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[direction][0];
            int newY = x + dirs[direction][1];
            if (!visited.contains(newX + "," + newY) && robot.move()) {
                visited.add(newX + "," + newY);
                dfs(robot, visited, newX, newY, direction);
            }
            direction = (direction + 1) % 4;
            robot.turnRight();
        }
        // Return back to origin place and with correct direction
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
}

interface Robot {
    boolean move();
    void turnLeft();
    void turnRight();
    void clean();
}