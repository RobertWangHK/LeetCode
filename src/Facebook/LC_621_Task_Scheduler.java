package Facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_621_Task_Scheduler {

    public int leastInterval_Simplified(char[] tasks, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;

        for (int i  = 0; i < tasks.length; i++) {
            int task = tasks[i];
            if (!map.containsKey(task) || index - map.get(task) > n) {
                map.put(task, index);
            }
            else {
                index += 1;
                i -= 1;
            }
        }
        return index + 1;
    }

    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'a'] += 1;
        }
        Arrays.sort(counts);
        int maxCount = counts[counts.length - 1];
        int cnt = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == maxCount) cnt += 1;
        }

        return Math.max(tasks.length, (n + 1) * (maxCount - 1) + cnt);
    }
}
