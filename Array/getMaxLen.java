package Array;
public class getMaxLen {
    /*
     * https://leetcode.com/problems/maximum-length-of-subarray-with-positive-
     * product/
     * 1567. Maximum Length of Subarray With Positive Product
     * Given an array of integers nums, find the maximum length of a subarray where
     * the product of all its elements is positive.
     * A subarray of an array is a consecutive sequence of zero or more values taken
     * out of that array.
     * Return the maximum length of a subarray with positive product.
     * Example 1:
     * Input: nums = [1,-2,-3,4]
     * Output: 4
     * Explanation: The array nums already has a positive product of 24.
     * Example 2:
     * Input: nums = [0,1,-2,-3,-4]
     * Output: 3
     * Explanation: The longest subarray with positive product is [1,-2,-3] which
     * has a product of 6.
     * Notice that we cannot include 0 in the subarray since that'll make the
     * product 0 which is not positive.
     * Example 3:
     * Input: nums = [-1,-2,-3,0,1]
     * Output: 2
     * Explanation: The longest subarray with positive product is [-1,-2] or
     * [-2,-3].
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static int getMaxLen(int[] nums) {
        int maxLen = 0;
        int posLen = 0; // Length of subarray with positive product
        int negLen = 0; // Length of subarray with negative product

        for (int num : nums) {
            if (num > 0) {
                posLen++;
                negLen = (negLen > 0) ? negLen + 1 : 0;
            } else if (num < 0) {
                int temp = posLen;
                posLen = (negLen > 0) ? negLen + 1 : 0;
                negLen = temp + 1;
            } else {
                posLen = 0;
                negLen = 0;
            }

            maxLen = Math.max(maxLen, posLen);
        }

        return maxLen;
    }
}