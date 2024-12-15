package Array;

import java.util.*;

public class kSum {
    /*
     * https://leetcode.com/problems/find-the-k-sum-of-an-array/description/
     * 2386. Find the K-Sum of an Array
     * You are given an integer array nums and a positive integer k. You can choose
     * any subsequence of the array and sum all of its elements together.
     * We define the K-Sum of the array as the kth largest subsequence sum that can
     * be obtained (not necessarily distinct).
     * Return the K-Sum of the array.
     * A subsequence is an array that can be derived from another array by deleting
     * some or no elements without changing the order of the remaining elements.
     * Note that the empty subsequence is considered to have a sum of 0.
     * Example 1:
     * Input: nums = [2,4,-2], k = 5
     * -2,2,4
     * Output: 2
     * Explanation: All the possible subsequence sums that we can obtain are the
     * following sorted in decreasing order:
     * - 6, 4, 4, 2, 2, 0, 0, -2.
     * The 5-Sum of the array is 2.
     * Example 2:
     * Input: nums = [1,-2,3,4,-10,12], k = 16
     * Output: 10
     * Explanation: The 16-Sum of the array is 10.
     * 139. Word Break
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        kSum solution = new kSum();
        int[] nums = { 2, 3, 1 };
        int k = 2;
        long result = solution.kSum(nums, k);
        System.out.println("K-Sum: " + result); // Output: 5

        System.out.println(solution.kSum(new int[]{2,4,-2},5));
    }

    /*
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:O(nlogn+klogk) SC: O(n+k)
     */
    public long kSum(int[] nums, int k) {
        long maxSum = 0;
        int n = nums.length;
        // Calculate the max sum of all elements considering all are positive
        for (int num : nums) {
            if (num > 0) {
                maxSum += num;
            }
        }
        // Make all elements positive and sort the array
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        // PriorityQueue to keep track of largest sums (using a max heap)
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        pq.offer(new long[] { maxSum, 0 });
        // Iterate to find the Kth largest sum
        while (k > 1) {
            long[] top = pq.poll();
            long currentSum = top[0];
            int index = (int) top[1];
            if (index < n) {
                pq.offer(new long[] { currentSum - nums[index], index + 1 });
                if (index > 0) {
                    // Add back the previous element to explore a different combination of the
                    // subsequence
                    pq.offer(new long[] { currentSum - nums[index] + nums[index - 1], index + 1 });
                }
            }
            k--;
        }
        return pq.poll()[0];
    }
}
