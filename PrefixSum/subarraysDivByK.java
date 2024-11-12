package PrefixSum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class subarraysDivByK {
    /*
     * https://leetcode.com/problems/subarray-sums-divisible-by-k/
     * 974. Subarray Sums Divisible by K
     * Given an integer array nums and an integer k, return the number of non-empty
     * subarrays that have a sum divisible by k.
     * A subarray is a contiguous part of an array.
     * Example 1:
     * Input: nums = [4,5,0,-2,-3,1], k = 5
     * Output: 7
     * Explanation: There are 7 subarrays with a sum divisible by k = 5:
     * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
     * Example 2:
     * Input: nums = [5], k = 9
     * Output: 0
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        // Test data
        int[] nums = { 4, 5, 0, -2, -3, 1 };
        int k = 5;

        // Call the function and print the result
        int result = subarraysDivByK(nums, k);
        System.out.println("Number of subarrays divisible by " + k + ": " + result);
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    // [4,5,0,-2,-3,1], k = 5 pref (0,0)(4,1,2,3)(2,4)
    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, List<Integer>> prefix = new HashMap<>();
        prefix.put(0, new ArrayList<Integer>(List.of(0)));
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int complement = 5 - sum % 5;
            if (prefix.containsKey(complement)) {
                for (int j : prefix.get(complement)) {
                    count += i - j - 1;
                }

            }
            prefix.getOrDefault(sum % 5, new ArrayList<Integer>()).add(i + 1);
        }
        return count;
    }
}