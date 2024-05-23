package TwoPointers;

import java.util.Arrays;

import Array.printPermutations;

public class sortColors {
    /*
     * https://leetcode.com/problems/sort-colors/description/
     * 75. Sort Colors
     * Given an array nums with n objects colored red, white, or blue, sort them
     * in-place so that objects of the same color are adjacent, with the colors in
     * the order red, white, and blue.
     * 
     * We will use the integers 0, 1, and 2 to represent the color red, white, and
     * blue, respectively.
     * 
     * You must solve this problem without using the library's sort function.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * Example 2:
     * 
     * Input: nums = [2,0,1]
     * Output: [0,1,2]
     * 
     * 
     * Constraints:
     * 
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] is either 0, 1, or 2.
     * 
     * 
     * Follow up: Could you come up with a one-pass algorithm using only constant
     * extra space?
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] array = new int[] { 2, 0, 2, 1, 1, 0 };
        sortColors(array);
        System.out.println(Arrays.toString(array));
         array = new int[] { 2,0,1 };
        sortColors(array);
        System.out.println(Arrays.toString(array));
        
    }

    /*
     * TC:O(n) SC: O(1)
     * #Notes
     * #Review
     * #Idea:To have 3 pointers left for 0, mid for 1 and right for 2
     * if the mid ==0 swap and move left and mid, if =1 move mid only if =2 swap
     * with right and move right
     */
    public static void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;
        while (mid <= right) {

            if (nums[mid] == 0) {
                // swap
                swap(left, mid, nums);
                mid++;
                left++;
            } else if (nums[mid] == 1)
                mid++;
            else {
                // swap
                swap(mid, right, nums);
                right--;
            }

        }
    }

    private static void swap(int i, int j, int[] nums) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
   // TC:O(n) SC: O(3)
   // #Idea: count for 0,1,2 and fill the array
    public static void sortColors1(int[] nums) {
        int zeros = 0, ones = 0, twoes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeros++;
            else if (nums[i] == 1)
                ones++;
            else
                twoes++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < zeros)
                nums[i] = 0;
            else if (i < zeros + ones)
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }
}