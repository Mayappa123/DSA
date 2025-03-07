//2054. Two Best Non-Overlapping Events

// You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. 
//The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. 
//You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.

// Return this maximum sum.

// Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. 
//More specifically, if you attend an event with end time t, the next event must start at or after t + 1.

import java.util.*;

public class Non_Overlapping_Events {

    public static int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int max = 0, ans = 0;
        pq.add(new int[] { events[0][1], events[0][2] });

        for (int i = 1; i < events.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] < events[i][0]) {
                int a[] = pq.poll();
                max = Math.max(max, a[1]);
            }
            ans = Math.max(ans, max + events[i][2]);
            pq.add(new int[] { events[i][1], events[i][2] });
        }
        while (!pq.isEmpty()) {
            ans = Math.max(ans, pq.poll()[1]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] events = { { 1, 3, 2 }, { 4, 5, 2 }, { 2, 4, 3 } }; // 4
        System.out.println(maxTwoEvents(events));
    }
}
