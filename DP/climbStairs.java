package DP;

public class climbStairs {
    /*
     * https://leetcode.com/problems/climbing-stairs/description/
     * 70. Climbing Stairs
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can
     * you climb to the top?
     * Example 1:
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */

    // O(n) O(1)
    public int climbStairs03(int n) {
        int before = 1, previous = 1;
        while (n-- > 0)
            before = (previous += before) - before;
        return before;
    }

    public int climbStairs00(int n) {
        if (n < 4) {
            return n;
        }
        int before = 1, previous = 2;
        for (int i = 4; i <= n; i++) {
            int tempBefore = before;
            before = previous;
            previous += tempBefore;
        }
        return previous;
    }

    // Dynamic Programming
    // O(n) O(n)
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Recursion with Memoization
    // O(n) O(n)
    public int climbStairs01(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }

    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

    // Brute force
    // Time complexity : O(2^n) S: O(1)
    public int climbStairs02(int n) {
        return climb_Stairs(0, n);
    }

    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
}