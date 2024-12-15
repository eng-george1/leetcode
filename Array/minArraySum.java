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
        Arrays.sort(nums);
        int op1better = 6;
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b,
        // a));
        // for (int i = 0; i < nums.length; i++) {
        // pq.add(nums[i]);
        // }
        for (int i = 1; i < op1 + op2; i++) {
            for (int j = nums.length - 1; j < 0; j--) {
                if (nums[j] > op1better && op1 != 0) {
                    // apply op1
                    nums[j] = (int) Math.ceil(nums[j] / 2);
                } else {
                    // apply op2
                    nums[j] = nums[j] - k;
                }
            }

        }
    }
}