package a_Basics;

import java.sql.Time;

public class LongestCommonSubsequence {
    /*
     * Given two strings, s1 and s2, the task is to find the length of the Longest
     * Common Subsequence. If there is no common subsequence, return 0.
     * A subsequence is a string generated from the original string by deleting 0 or
     * more characters and without changing the relative order of the remaining
     * characters.
     */

    public static void main(String[] args) {
        String X = "ABCDGH";
        String Y = "AEDFHR";
        int m = X.length();
        int n = Y.length();

        System.out.println("Length of LCS: " + lcs(X, Y, m, n));
    }

    /*
     * [Naive Approach] Using Recursion – O(2 ^ min(m, n)) Time and O(min(m, n))
     * Space, trying all possible subsequences of one string and checking if they
     * are subsequences of the other string
     * Recursive function to find the length of LCS
     */
    public static int lcs(String X, String Y, int m, int n) {
        // Base case: If either string is empty, LCS length is 0
        if (m == 0 || n == 0) {
            return 0;
        }

        // If last characters match, include them in LCS
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return 1 + lcs(X, Y, m - 1, n - 1);
        } else {
            // If last characters don't match, take the maximum
            return Math.max(lcs(X, Y, m - 1, n), lcs(X, Y, m, n - 1));
        }
    }

    /*
     * Using Dynamic Programming
     * Time Complexity: O(m * n) ,where m and n are lengths of strings s1 and s2.
     * Auxiliary Space: O(m * n)
     * Returns length of LCS for s1[0..m-1], s2[0..n-1]
     */
    static int lcs(String s1, String s2, int m, int n, int[][] memo) {
        // Base Case
        if (m == 0 || n == 0)
            return 0;

        // Already exists in the memo table
        if (memo[m][n] != -1)
            return memo[m][n];

        // Match
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        }

        // Do not match
        return memo[m][n] = Math.max(lcs(s1, s2, m, n - 1, memo),
                lcs(s1, s2, m - 1, n, memo));
    }

}
