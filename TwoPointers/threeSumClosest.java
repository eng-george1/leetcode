package TwoPointers;

import java.util.Arrays;

public class threeSumClosest {
    /*
     * https://leetcode.com/problems/3sum-closest/description/
     * 16. 3Sum Closest
     * Given an integer array nums of length n and an integer target, find three
     * integers in nums such that the sum is closest to target.
     * Return the sum of the three integers.
     * You may assume that each input would have exactly one solution.
     * Example 1:
     * Input: nums = [-1,2,1,-4], target = 1
     * Output: 2
     * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     * Example 2:
     * Input: nums = [0,0,0], target = 1
     * Output: 0
     * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
    
     * algorithm.
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     *  * TC:O(n^2) SC: O(logn) to O(n), depending on the implementation of the sorting
     */
    // [-1,2,1,-4], target = 1
    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n && diff != 0; ++i) {
            int lo = i + 1;
            int hi = n - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    ++lo;
                } else {
                    --hi;
                }
            }
        }
        return target - diff;
    }
}