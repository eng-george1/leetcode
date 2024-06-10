package a_Basics.Sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] array = new int[] { 5, 2, 3, 1 };
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    /*
     * TC:O(nlogn) SC: O(n)
     * #Notes
     * https://www.geeksforgeeks.org/merge-sort/#
     * Best,average and worst Case: O(n log n)Space Complexity: O(n)
     * Advantages of Merge Sort:
     * Stability: Merge sort is a stable sorting algorithm
     * The divide-and-conquer approach is straightforward.
     * Disadvantage of Merge Sort:
     * Space complexity
     * Not in-place
     * #LastReview
     * #Review
     * #Idea:
     * call method with 0 to len index
     * find middle
     * sort left(left ,middle) and right(middle+1,right)
     * merge the two arrays --> copy to temp arrays l, r --> loop with select the
     * smallest
     */
    public static void sort(int[] arrays) {
        sort(arrays, 0, arrays.length - 1);
    }

    // top-down merge sort
    // Method to sort an array using merge sort
    static void sort(int[] array, int left, int right) {
        // #Notes:Condition is important
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Sort first and second halves
            sort(array, left, middle);
            sort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    // Method to merge two subarrays of array[]
    static void merge(int[] array, int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        // #Notes: int n1 = middle - left + 1;
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[middle + 1 + j];

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        // #Notes:Start from left
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

}