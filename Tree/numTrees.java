package Tree;

import a_Basics.Tree.TreeNode;

public class numTrees {
    /*
     * https://leetcode.com/problems/unique-binary-search-trees/description/
     * 96. Unique Binary Search Trees
     * Given an integer n, return the number of structurally unique BST's (binary
     * search trees) which has exactly n nodes of unique values from 1 to n.
     * Example 1:
     * Input: n = 3
     * Output: 5
     * Example 2:
     * Input: n = 1
     * Output: 1
     * #PatchNo
     * #Need-Memorize
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n^2) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    //Need-Memorize
    public int numTrees(int n) {
        // Create a DP array to store the number of unique BSTs for each value of i
        int[] dp = new int[n + 1];

        // Base cases
        // Empty tree has one way to form
        dp[0] = 1;
        // Tree with single node has one way to form
        dp[1] = 1;

        // Calculate number of unique BSTs for each value from 2 to n
        for (int i = 2; i <= n; i++) {
            // For each value of i, try each number as root
            for (int j = 1; j <= i; j++) {
                // Number of unique BSTs =
                // (number of unique left subtrees) * (number of unique right subtrees)
                // Left subtree will have j-1 nodes (less than root)
                // Right subtree will have i-j nodes (greater than root)
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}