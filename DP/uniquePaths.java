package DP;

import java.util.Arrays;
import java.util.Map;

import a_Basics.stack;

public class uniquePaths {
    /*
     * https://leetcode.com/problems/unique-paths/description/
     * 62. Unique Paths
     * There is a robot on an m x n grid. The robot is initially located at the
     * top-left corner (i.e., grid[0][0]). The robot tries to move to the
     * bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
     * either down or right at any point in time.
     * Given the two integers m and n, return the number of possible unique paths
     * that the robot can take to reach the bottom-right corner.
     * The test cases are generated so that the answer will be less than or equal to
     * 2 * 109.
     * Example 1:
     * Input: m = 3, n = 7
     * Output: 28
     * Example 2:
     * Input: m = 3, n = 2
     * Output: 3
     * Explanation: From the top-left corner, there are a total of 3 ways to reach
     * the bottom-right corner:
     * 1. Right -> Down -> Down
     * 2. Down -> Down -> Right
     * 3. Down -> Right -> Down
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.err.println(uniquePaths01(3, 7));
        System.err.println(uniquePaths01(3, 2));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    // O(mXn) O(mXn)
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];
        for (int[] arr : d) {
            Arrays.fill(arr, 1);
        }
        for (int col = 1; col < m; ++col) {
            for (int row = 1; row < n; ++row) {
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }
        return d[m - 1][n - 1];
    }
     // Recursion O(2^(m+n)) O(m+n)
     public static int uniquePaths02(int m, int n, Map<String, Integer> dp) {
        String key = m + "," + n;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        // if one of dim=1 there is only one way
        if (m == 1 || n == 1) {
            return 1;
        }
        dp.put(key, uniquePaths01(m - 1, n) + uniquePaths01(m, n - 1));
        return dp.get(key);
    }

    // Recursion O(2^(m+n)) O(m+n)
    public static int uniquePaths01(int m, int n) {
        // if one of dim=1 there is only one way
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths01(m - 1, n) + uniquePaths01(m, n - 1);
    }

   

    // Recursion O(2^(m+n)) O(m+n)
    public static int uniquePaths03(int m, int n) {
        if (m == 1 && n == 1)
            return 1;
        if (m == 0 || n == 0)
            return 0;
        return uniquePaths01(m - 1, n) + uniquePaths01(m, n - 1);
    }
}