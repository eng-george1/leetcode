//package ;

import java.util.Arrays;
import java.util.PriorityQueue;

public class minMeetingRooms {
    /*
     * https://leetcode.com/problems/meeting-rooms-ii/description/
     * 253. Meeting Rooms II
     * Given an array of meeting time intervals intervals where intervals[i] =
     * [starti, endi], return the minimum number of conference rooms required.
     * Example 1:
     * Input: intervals = [[0,30],[5,10],[15,20]]
     * Output: 2
     * Example 2:
     * Input: intervals = [[7,10],[2,4]]
     * Output: 1
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(minMeetingRooms(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = pq.remove();

            if (prev[1] > curr[0]) {
                pq.add(prev);
                pq.add(curr);
            } else {
                prev[1] = curr[1];
                pq.add(prev);
            }
        }

        return pq.size();
    }
}