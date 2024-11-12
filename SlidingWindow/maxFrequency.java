package SlidingWindow;

import java.util.Arrays;

public class maxFrequency {
    /*
     * https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
     * https://www.youtube.com/watch?app=desktop&v=vgBrQ0NM5vE&ab_channel=NeetCode
     * 1838. Frequency of the Most Frequent Element
     * The frequency of an element is the number of times it occurs in an array.
     * You are given an integer array nums and an integer k. In one operation, you
     * can choose an index of nums and increment the element at that index by 1.
     * Return the maximum possible frequency of an element after performing at most
     * k operations.
     * Example 1:
     * Input: nums = [1,2,4], k = 5
     * Output: 3
     * Explanation: Increment the first element three times and the second element
     * two times to make nums = [4,4,4].
     * 4 has a frequency of 3.
     * Example 2:
     * Input: nums = [1,4,8,13], k = 5
     * Output: 2
     * Explanation: There are multiple optimal solutions:
     * - Increment the first element three times to make nums = [4,4,8,13]. 4 has a
     * frequency of 2.
     * - Increment the second element four times to make nums = [1,8,8,13]. 8 has a
     * frequency of 2.
     * - Increment the third element five times to make nums = [1,4,13,13]. 13 has a
     * frequency of 2.
     * Example 3:
     * Input: nums = [3,9,6], k = 2
     * Output: 1
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
    // 1,1,1,2,2,4 k=2
    // O(nlogn)
    public int maxFrequency(int[] nums, int k) {
        // Step 1: Sort the array to bring similar numbers closer together.
        Arrays.sort(nums);

        // Initialize variables:
        int left = 0; // Left pointer for the sliding window
        int ans = 0; // To store the maximum frequency found
        long curr = 0; // To store the sum of the current window

        // Step 2: Iterate over the array with the right pointer
        for (int right = 0; right < nums.length; right++) {
            long target = nums[right]; // The target value we want to match to

            // Add the current number to the cumulative sum for the window
            curr += target;

            // Step 3: Check if we need to shrink the window
            // Calculate the total cost needed to make all elements in the current window
            // equal to 'target'.
            // The cost is: (number of elements in the window) * (target value) - (sum of
            // elements in the window)
            while ((right - left + 1) * target - curr > k) {
                // If the cost is greater than k, reduce the window size from the left
                curr -= nums[left];
                left++;
            }

            // Step 4: Update the maximum frequency with the size of the current valid
            // window
            ans = Math.max(ans, right - left + 1);
        }

        // Step 5: Return the maximum frequency found
        return ans;
    }

    // We no longer care about any windows with lengths less than len, because they
    // could not possibly improve on our answer.
    public static int maxFrequency1(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long curr = 0;

        for (int right = 0; right < nums.length; right++) {
            long target = nums[right];
            curr += target;

            if ((right - left + 1) * target - curr > k) {
                curr -= nums[left];
                left++;
            }
        }

        return nums.length - left;
    }

}