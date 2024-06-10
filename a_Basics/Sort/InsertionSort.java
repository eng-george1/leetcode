package a_Basics.Sort;

import java.util.Arrays;

public class InsertionSort {
    /*
     * https://www.youtube.com/watch?v=EdIKIf9mHk0&list=PLOmdoKois7_FK-
     * ySGwHBkltzB11snW7KQ&ab_channel=megaovermoc
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] array = new int[] { 5, 2, 3, 1 };
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    /*
     * TC:O(n^2) SC: O(1)
     * #Notes
     * compare and swap until no need for swap
     * https://www.geeksforgeeks.org/insertion-sort/#
     * Best O(n) If the list is already sorted
     * average and worst Case: O(n^2)Space Complexity: O(1)
     * Advantages:
     * Stability: a stable sorting algorithm
     * Disadvantage:
     * O(n^2)
     * Not in-place
     * #LastReview
     * #Review
     * #Idea:
     * 
     */

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (nums[j] >= nums[j - 1])
                    break;
                swap(nums, j, j - 1);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

}