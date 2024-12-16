package Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class minArraySum {
    /*
     * https://leetcode.com/problems/minimum-array-sum/description/
     * 3366. Minimum Array Sum
     * You are given an integer array nums and three integers k, op1, and op2.
     * You can perform the following operations on nums:
     * Operation 1: Choose an index i and divide nums[i] by 2, rounding up to the
     * nearest whole number. You can perform this operation at most op1 times, and
     * not more than once per index.
     * Operation 2: Choose an index i and subtract k from nums[i], but only if
     * nums[i] is greater than or equal to k. You can perform this operation at most
     * op2 times, and not more than once per index.
     * Note: Both operations can be applied to the same index, but at most once
     * each.
     * Return the minimum possible sum of all elements in nums after performing any
     * number of operations.
     * Example 1:
     * Input: nums = [2,8,3,19,3], k = 3, op1 = 1, op2 = 1
     * Output: 23
     * Explanation:
     * Apply Operation 2 to nums[1] = 8, making nums[1] = 5.
     * Apply Operation 1 to nums[3] = 19, making nums[3] = 10.
     * The resulting array becomes [2, 5, 3, 10, 3], which has the minimum possible
     * sum of 23 after applying the operations.
     * Example 2:
     * Input: nums = [2,4,3], k = 3, op1 = 2, op2 = 1
     * Output: 3
     * Explanation:
     * Apply Operation 1 to nums[0] = 2, making nums[0] = 1.
     * Apply Operation 1 to nums[1] = 4, making nums[1] = 2.
     * Apply Operation 2 to nums[2] = 3, making nums[2] = 0.
     * The resulting array becomes [1, 2, 0], which has the minimum possible sum of
     * 3 after applying the operations.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:O(n) SC: O(n)
     */
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        // ========================================================================
        int[][][] dp = new int[nums.length][op1 + 1][op2 + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= op1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        // ===========================================================================
        return solve(nums, k, dp, 0, op1, op2);

    }

    int solve(int[] nums, int k, int[][][] dp, int idx, int op1, int op2) {
        if (idx == nums.length)
            return 0;
        if (dp[idx][op1][op2] != -1)
            return dp[idx][op1][op2];

        int ans = Integer.MAX_VALUE;
        if (op1 != 0) {
            // CASE-1
            int sumOp1 = ((int) Math.ceil(nums[idx] / 2.00)) + solve(nums, k, dp, idx + 1, op1 - 1, op2);
            ans = Math.min(ans, sumOp1);
        }
        if (op2 != 0 && nums[idx] >= k) {
            // CASE-2
            int sumOp2 = (nums[idx] - k) + solve(nums, k, dp, idx + 1, op1, op2 - 1);
            ans = Math.min(ans, sumOp2);
        }
        if (op1 != 0 && op2 != 0) {
            int afterOp1 = (int) Math.ceil(nums[idx] / 2.00);
            if (afterOp1 >= k) {
                // CASE-3
                int sumOp1Op2 = ((afterOp1 - k) + solve(nums, k, dp, idx + 1, op1 - 1, op2 - 1));
                ans = Math.min(ans, sumOp1Op2);
            }
            if (nums[idx] >= k) {
                // CASE-4
                int sumOp2Op1 = ((int) Math.ceil((nums[idx] - k) / 2.00))
                        + solve(nums, k, dp, idx + 1, op1 - 1, op2 - 1);
                ans = Math.min(ans, sumOp2Op1);
            }
        }
        // CASE-5
        int sumNoOp = nums[idx] + solve(nums, k, dp, idx + 1, op1, op2);

        ans = dp[idx][op1][op2] = Math.min(ans, sumNoOp);

        return ans;

    }

}