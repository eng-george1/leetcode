package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intervalIntersection {
    /*
     * https://leetcode.com/problems/interval-list-intersections/description/
     * 986. Interval List Intersections
     * You are given two lists of closed intervals, firstList and secondList, where
     * firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list
     * of intervals is pairwise disjoint and in sorted order.
     * Return the intersection of these two interval lists.
     * A closed interval [a, b] (with a <= b) denotes the set of real numbers x with
     * a <= x <= b.
     * The intersection of two closed intervals is a set of real numbers that are
     * either empty or represented as a closed interval. For example, the
     * intersection of [1, 3] and [2, 4] is [2, 3].
     * Example 1:
     * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList =
     * [[1,5],[8,12],[15,24],[25,26]]
     * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     * Example 2:
     * Input: firstList = [[1,3],[5,9]], secondList = []
     * Output: []
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        int[][] firstList = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] secondList = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

        int[][] result = intervalIntersection(firstList, secondList);

        // Print the result
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }

    /*
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:O(n+m) SC: O(n+m)
     */
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int indexA = 0, indexB = 0;
        List<int[]> result = new ArrayList<>();
        while (indexA < firstList.length && indexB < secondList.length) {
            int[] first = firstList[indexA];
            int[] second = secondList[indexB];
            int intersectA = Math.max(first[0], second[0]);
            int intersectB = Math.min(first[1], second[1]);
            if (intersectA <= intersectB)
                result.add(new int[] { intersectA, intersectB });
            if (intersectB == first[1])
                indexA++;
            else
                indexB++;
        }
        return result.toArray(new int[result.size()][]);
    }
}