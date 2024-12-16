package Array;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    /*
     * https://leetcode.com/problems/find-median-from-data-stream/description/
     * 295. Find Median from Data Stream
     * The median is the middle value in an ordered integer list. If the size of the
     * list is even, there is no middle value, and the median is the mean of the two
     * middle values.
     * For example, for arr = [2,3,4], the median is 3.
     * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
     * Implement the MedianFinder class:
     * MedianFinder() initializes the MedianFinder object.
     * void addNum(int num) adds the integer num from the data stream to the data
     * structure.
     * double findMedian() returns the median of all elements so far. Answers within
     * 10-5 of the actual answer will be accepted.
     * Example 1:
     * Input
     * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
     * [[], [1], [2], [], [3], []]
     * Output
     * [null, null, null, 1.5, null, 2.0]
     * Explanation
     * MedianFinder medianFinder = new MedianFinder();
     * medianFinder.addNum(1); // arr = [1]
     * medianFinder.addNum(2); // arr = [1, 2]
     * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
     * medianFinder.addNum(3); // arr[1, 2, 3]
     * medianFinder.findMedian(); // return 2.0
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * #Notes we have list and we need a way to get the max and the min and the midian
     * #LastReview
     * #Review
     * #Idea: two heap(max and min)
     * TC:O(n) SC: O(n)
     */
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean even = true;
    MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        even = true;
    }
    // O(1)
    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }
    // O(logn)
    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
}