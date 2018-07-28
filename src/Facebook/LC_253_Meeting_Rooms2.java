package Facebook;

import Utils.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_253_Meeting_Rooms2 {
    /**
     The idea is that two intervals: if 2nd interval's start time is later than 1st interval's end time, then these two can be combined into one interval, or in other words, don't need a second reference room. If 2nd interval's start time < 1st interval's end time, then need a second interval.
     Therefore, the idea is to keep track of the start-time (for 2nd interval to compare with), and 1st interval (the end to time to try to combine as much as succeeding intervals as possible).
     */
    public int minMeetingRooms(Interval[] intervals) {
        // Edge case
        if (intervals == null || intervals.length == 0) return 0;
        // Sort based on start time of intervals
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        // PriorityQueue to keep track of end time
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });

        // Iterate through the original array based on start time
        pq.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval top = pq.poll();
            if (top.end <= intervals[i].start) {
                top.end = intervals[i].end;
            }
            else {
                pq.offer(intervals[i]);
            }
            pq.offer(top);

        }

        return pq.size();
    }
}
