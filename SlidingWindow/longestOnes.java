package SlidingWindow;

//package ;
public class longestOnes {
    /*
     * https://leetcode.com/problems/max-consecutive-ones-iii/description/
     * 1004. Max Consecutive Ones III
     * Given a binary array nums and an integer k, return the maximum number of
     * consecutive 1's in the array if you can flip at most k 0's.
     * Example 1:
     * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
     * Output: 6
     * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     * Example 2:
     * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
     * Output: 10
     * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        // Test data
        int[] nums = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k = 3;

        // Call the function and print the result
        int result = longestOnes(nums, k);
        System.out.println("Longest subarray of 1's after flipping at most " + k + " zeros: " + result);
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea: it not trace the index it trace count only the example 19-9=10
     * we have to find the MAXIMUM window, we never reduce the size of the window. We either increase the size of the window or remain same but never reduce the size.
     */
    // [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[right] == 0) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window
            // size same.
            if (k < 0) {
                // If the left element to be thrown out is zero we increase k.
                k += 1 - nums[left];
                left++;
            }
        }
        return right - left;
    }

    public static int longestOnes1(int[] nums, int k) {
        int left = 0;
        int maxLength = 0;

        // Traverse through the array with the right pointer
        for (int right = 0; right < nums.length; right++) {
            // If the current element is 0, decrement k
            if (nums[right] == 0) {
                k--;
            }

            // If k is negative, it means we have flipped more than allowed zeros
            while (k < 0) {
                // Move the left pointer to shrink the window
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }

            // Calculate the length of the current window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}