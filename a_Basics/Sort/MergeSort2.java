package a_Basics.Sort;

import java.util.Arrays;

public class MergeSort2 {
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] array = new int[] { 5, 2, 3, 1 };
        mergeSort2(array);
        System.out.println(Arrays.toString(array));
    }

    /*
     * TC:O(nlogn) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea: bottom-up merge sort
     * 
     */

    // bottom-up merge sort
    // Method to sort an array using merge sort
    private static void mergeSort2(int[] nums) {
        // Start with subarray size 1, doubling the size each iteration
        for (int size = 1; size < nums.length; size *= 2) {
            // Iterate through the array in chunks of size 2*size
            for (int i = 0; i < nums.length - size; i += 2 * size) {
                // Calculate the middle and end indices for merging
                int mid = i + size - 1;
                int end = Math.min(i + 2 * size - 1, nums.length - 1);

                // Merge the current subarrays
                merge2(nums, i, mid, end);
            }
        }
    }

    // Helper method to merge two sorted subarrays
    private static void merge2(int[] nums, int left, int mid, int right) {
        // Temporary array to store merged elements
        int[] temp = new int[right - left + 1];

        // Pointers for traversing the subarrays
        int i = left; // Start of the left subarray
        int j = mid + 1; // Start of the right subarray
        int k = 0; // Index for the temporary array

        // Merge the subarrays while there are elements in either
        while (i <= mid || j <= right) {
            // If the left subarray is exhausted or the current element in the right
            // subarray is smaller
            if (i > mid || (j <= right && nums[i] > nums[j])) {
                temp[k++] = nums[j++];
            } else {
                // Otherwise, take the element from the left subarray
                temp[k++] = nums[i++];
            }
        }

        // Copy the merged elements back into the original array
        System.arraycopy(temp, 0, nums, left, right - left + 1);
    }

}