package Array;

import java.util.Arrays;

public class rotateArray {
    /*
     * https://leetcode.com/problems/rotate-array/description/
     * 189. Rotate Array
     * Given an integer array nums, rotate the array to the right by k steps, where
     * k is non-negative.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     * Example 2:
     * 
     * Input: nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     * 
     * 
     * Explanation:
     * Reverse the Entire Array:
     * 
     * Input: [1,2,3,4,5,6,7]
     * After reversing: [7,6,5,4,3,2,1]
     * Reverse the First k Elements:
     * 
     * Reverse first 3 elements: [7,6,5] → [5,6,7]
     * Result: [5,6,7,4,3,2,1]
     * Reverse the Remaining Elements:
     * 
     * Reverse last 4 elements: [4,3,2,1] → [1,2,3,4]
     * Result: [5,6,7,1,2,3,4]
     * 
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #Review
     * #Idea: reverse the array and reverse 0 to k%len and reverse the other
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}