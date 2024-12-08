package DP;

import Graph.numIslands;

public class minCostClimbingStairs {
    /*
     * https://leetcode.com/problems/min-cost-climbing-stairs/description/
     * 746. Min Cost Climbing Stairs
     * You are given an integer array cost where cost[i] is the cost of ith step on
     * a staircase. Once you pay the cost, you can either climb one or two steps.
     * You can either start from the step with index 0, or the step with index 1.
     * Return the minimum cost to reach the top of the floor.
     * Example 1:
     * Input: cost = [10,15,20]
     * Output: 15
     * Explanation: You will start at index 1.
     * - Pay 15 and climb two steps to reach the top.
     * The total cost is 15.
     * Example 2:
     * Input: cost = [1,100,1,1,1,100,1,1,100,1]
     * Output: 6
     * Explanation: You will start at index 0.
     * - Pay 1 and climb two steps to reach index 2.
     * - Pay 1 and climb two steps to reach index 4.
     * - Pay 1 and climb two steps to reach index 6.
     * - Pay 1 and climb one step to reach index 7.
     * - Pay 1 and climb two steps to reach index 9.
     * - Pay 1 and climb one step to reach the top.
     * The total cost is 6.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(minCostClimbingStairs(new int[] { 10, 15, 20 }));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length < 1)
            return 0;
        return cal(cost, 0);
    }

    static int cal(int[] cost, int index) {
        if (index >= cost.length - 1)
            return 0;

        return Math.min(cost[index] + Math.min((cal(cost, index + 1)),cal(cost, index+2)),
                        cost[index+1] + Math.min((cal(cost, index + 2)),cal(cost, index+3)));
    }

}