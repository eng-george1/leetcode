package Sorting;

import java.util.Arrays;

public class sortArray {
    /*
     * https://leetcode.com/problems/sort-an-array/description/
     * 912. Sort an Array
     * Given an array of integers nums, sort the array in ascending order and return
     * it.
     * 
     * You must solve the problem without using any built-in functions in O(nlog(n))
     * time complexity and with the smallest space complexity possible.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [5,2,3,1]
     * Output: [1,2,3,5]
     * Explanation: After sorting the array, the positions of some numbers are not
     * changed (for example, 2 and 3), while the positions of other numbers are
     * changed (for example, 1 and 5).
     * Example 2:
     * 
     * Input: nums = [5,1,1,2,0,0]
     * Output: [0,0,1,1,2,5]
     * Explanation: Note that the values of nums are not necessairly unique.
     * 
     * 
     * Constraints:
     * 
     * 1 <= nums.length <= 5 * 104
     * -5 * 104 <= nums[i] <= 5 * 104
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] array = new int[] { 5, 2, 3, 1 };
        array = sortArray(array);
        System.out.println(Arrays.toString(array));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private static void sortArray(int[] nums, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sortArray(nums, left, middle);
            sortArray(nums, middle + 1, right);
            mergeArray(nums, left, middle, right);
        }
    }

    private static void mergeArray(int[] nums, int left, int middle, int right) {
        // copy to temp

        int[] leftArr = new int[middle - left + 1];
        int[] rightArr = new int[right - middle];
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = nums[left + i];
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = nums[middle + 1 + i];
        }

        // merge
        int leftIn = 0, rightIn = 0, index = left;
        while (leftIn < leftArr.length && rightIn < rightArr.length) {
            if (leftArr[leftIn] <= rightArr[rightIn]) {
                nums[index] = leftArr[leftIn];
                leftIn++;
            } else {
                nums[index] = rightArr[rightIn];
                rightIn++;
            }
            index++;
        }
        // the rest
        while (leftIn < leftArr.length) {
            nums[index] = leftArr[leftIn];
            leftIn++;
            index++;
        }
        // the rest
        while (rightIn < rightArr.length) {
            nums[index] = rightArr[rightIn];
            rightIn++;
            index++;
        }
    }
}