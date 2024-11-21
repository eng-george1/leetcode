package a_Basics.Sort;

import java.util.Arrays;

public class BubbleSort {
    /*
     * https://www.youtube.com/watch?v=EdIKIf9mHk0&list=PLOmdoKois7_FK-
     * ySGwHBkltzB11snW7KQ&ab_channel=megaovermoc
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] array = new int[] { 5, 2, 3, 1 };
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    /*
     * TC:O(n^2) SC: O(1)
     * #Notes
     * swap until you put the max in the end every iteration 
     * https://www.geeksforgeeks.org/bubble-sort/
     * Best O(n) If the list is already sorted
     * average and worst Case: O(n^2)Space Complexity: O(1)
     * Advantages:
     * Stability: a stable sorting algorithm
     * Disadvantage:
     * O(n^2)
     * #LastReview
     * #Review
     * #Idea:
     * Adding isSwap to check if there is no swap this mean its sorted and we can
     * end
     * 
     */

    public static void bubbleSort(int[] nums) {
        for (int k = nums.length - 1; k >= 1; k--) {
            // #Idea:
            boolean isSwap = false;
            for (int i = 0; i < k; i++) {

                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                // There is no swap mean its already sorted
                break;
            }
        }
    }

    // #Idea: This is a clever way to swap two elements in an array without using a
    // temporary variable, using bitwise XOR. Let's break it down:
    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    // #Idea:This version is easier to understand and has no significant performance
    // drawbacks compared to the XOR method in most practical applications.
    private static void swap2(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}