package SlidingWindow;

public class numberOfSubarrays {
    /*
     * https://leetcode.com/problems/count-number-of-nice-subarrays/description/
     * 1248. Count Number of Nice Subarrays
     * Given an array of integers nums and an integer k. A continuous subarray is
     * called nice if there are k odd numbers on it.
     * Return the number of nice sub-arrays.
     * Example 1:
     * Input: nums = [1,1,2,1,1], k = 3
     * Output: 2
     * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and
     * [1,2,1,1].
     * Example 2:
     * Input: nums = [2,4,6], k = 1
     * Output: 0
     * Explanation: There are no odd numbers in the array.
     * Example 3:
     * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
     * Output: 16
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        // Test data
        int[] nums = { 1, 1, 2, 1, 1 };
        int k = 3;

        // Call the function and print the result
        // int result = numberOfSubarrays(nums, k);
        // System.out.println("Number of subarrays with exactly " + k + " odd numbers: "
        // + result);
        // Test data
        int[] nums1 = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        int k1 = 2;

        // Call the function and print the result
        int result1 = numberOfSubarrays(nums1, k1);
        System.out.println("Number of subarrays with exactly " + k1 + " odd numbers: " + result1);
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    // [2,2,2,1,2,2,1,2,2,2], k = 2
    public static int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 > 0)
                k--;
            if (k == 0)
                count++;
            while (k < 0) {
                k += nums[left] % 2;
                left++;
            }
        }
        return count;
    }
}