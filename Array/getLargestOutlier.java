package Array;

import java.util.HashMap;
import java.util.Map;

public class getLargestOutlier {
    /*
     * https://leetcode.com/problems/identify-the-largest-outlier-in-an-array/
     * description/
     * 3371. Identify the Largest Outlier in an Array
     * You are given an integer array nums. This array contains n elements, where
     * exactly n - 2 elements are special numbers. One of the remaining two elements
     * is the sum of these special numbers, and the other is an outlier.
     * An outlier is defined as a number that is neither one of the original special
     * numbers nor the element representing the sum of those numbers.
     * Note that special numbers, the sum element, and the outlier must have
     * distinct indices, but may share the same value.
     * Return the largest potential outlier in nums.
     * Example 1:
     * Input: nums = [2,3,5,10]
     * Output: 10
     * Explanation:
     * The special numbers could be 2 and 3, thus making their sum 5 and the outlier
     * 10.
     * Example 2:
     * Input: nums = [-2,-1,-3,-6,4]
     * Output: 4
     * Explanation:
     * The special numbers could be -2, -1, and -3, thus making their sum -6 and the
     * outlier 4.
     * Example 3:
     * Input: nums = [1,1,1,1,1,5,5]
     * Output: 5
     * Explanation:
     * The special numbers could be 1, 1, 1, 1, and 1, thus making their sum 5 and
     * the other 5 as the outlier.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] nums = { 2, 3, 5, 10 }; // Example input
        int result = getLargestOutlier(nums);
        System.out.println("Largest Outlier: " + result);
    }

    /*
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:O(n) SC: O(n)
     */
    public static int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int total = 0, res = Integer.MIN_VALUE;
        for (int num : nums) {
            total += num;
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            // assume num is the sum so remove(1 because it included in the sum 2 if it is
            // the sum) twice and if we have the rest is a number in the array it is the
            // outlier
            int outlier = total - num - num;
            if (count.getOrDefault(outlier, 0) > (outlier == num ? 1 : 0)) {
                res = Math.max(res, outlier);
            }
        }
        return res;
    }
}