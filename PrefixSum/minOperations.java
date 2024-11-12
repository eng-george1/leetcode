package PrefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minOperations {
    /*
     * https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-
     * equal/
     * https://www.youtube.com/watch?v=TUXKRTPWS6U&ab_channel=PrakharAgrawal
     * 2602. Minimum Operations to Make All Array Elements Equal
     * You are given an array nums consisting of positive integers.
     * You are also given an integer array queries of size m. For the ith query, you
     * want to make all of the elements of nums equal to queries[i]. You can perform
     * the following operation on the array any number of times:
     * Increase or decrease an element of the array by 1.
     * Return an array answer of size m where answer[i] is the minimum number of
     * operations to make all elements of nums equal to queries[i].
     * Note that after each query the array is reset to its original state.
     * Example 1:
     * Input: nums = [3,1,6,8], queries = [1,5]
     * Output: [14,10]
     * Explanation: For the first query we can do the following operations:
     * - Decrease nums[0] 2 times, so that nums = [1,1,6,8].
     * - Decrease nums[2] 5 times, so that nums = [1,1,1,8].
     * - Decrease nums[3] 7 times, so that nums = [1,1,1,1].
     * So the total number of operations for the first query is 2 + 5 + 7 = 14.
     * For the second query we can do the following operations:
     * - Increase nums[0] 2 times, so that nums = [5,1,6,8].
     * - Increase nums[1] 4 times, so that nums = [5,5,6,8].
     * - Decrease nums[2] 1 time, so that nums = [5,5,5,8].
     * - Decrease nums[3] 3 times, so that nums = [5,5,5,5].
     * So the total number of operations for the second query is 2 + 4 + 1 + 3 = 10.
     * Example 2:
     * Input: nums = [2,9,6,3], queries = [10]
     * Output: [20]
     * Explanation: We can increase each value in the array to 10. The total number
     * of operations will be 8 + 1 + 4 + 7 = 20.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        // Input data
        int[] nums = { 3, 1, 6, 8 };
        int[] queries = { 1, 5 };

        // Call the function
        List<Long> result = minOperations(nums, queries);

        // Print the result
        System.out.println("Result: " + result);
    }

    /*
     * TC:O(mlogn) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea: find the nearest index by binary search and use prefix --> query*indx-
     * prefix before +
     */
    // Input: nums = [3,1,6,8], queries = [1,5] 10-1,1 10-3,3 10-6,6
    public static List<Long> minOperations(int[] nums, int[] queries) {
        // Step 1: Sort the nums array
        Arrays.sort(nums);
        int n = nums.length;

        // Step 2: Compute the prefix sum array
        long[] prefix = new long[n + 1];
        prefix[0] = 0; // Initialize the first element as 0
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        List<Long> result = new ArrayList<>();
        for (int query : queries) {
            // Step 3: Find the index where the query would fit in the sorted array
            int idx = Arrays.binarySearch(nums, query);
            // if the number not there the binary search return -insertion-1 and to get the
            // nearest element use -idx - 1
            if (idx < 0)
                idx = -idx - 1;

            // Step 4: Calculate the left and right operations using prefix sums
            long leftSum = prefix[idx]; // Sum of elements to the left of idx
            long rightSum = prefix[n] - leftSum; // Sum of elements to the right of idx

            long leftOperations = (long) query * idx - leftSum;// expected sum-actual sum
            long rightOperations = rightSum - (long) query * (n - idx);// actual sum - expected

            // Step 5: Add the total operations to the result list
            long totalSteps = leftOperations + rightOperations;
            result.add(totalSteps);
        }

        return result;
    }

    // O(n*M)
    public static List<Long> minOperations1(int[] nums, int[] queries) {
        List<Long> result = new ArrayList<>();
        for (int qu : queries) {
            long totalSteps = 0;
            for (int num : nums) {
                totalSteps += Math.abs(qu - num);
            }
            result.add(totalSteps);
        }
        return result;
    }
}