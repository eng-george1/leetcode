package a_Basics.Sort;

import java.util.Arrays;

public class SelectionSort {
    /*
     * https://www.youtube.com/watch?v=EdIKIf9mHk0&list=PLOmdoKois7_FK-
     * ySGwHBkltzB11snW7KQ&ab_channel=megaovermoc
     * https://www.youtube.com/playlist?list=PLOmdoKois7_FK-ySGwHBkltzB11snW7KQ
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] array = new int[] { 5, 2, 3, 1 };
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    /*
     * TC:O(n^2) SC: O(1)
     * #Notes
     * get the min value and swap with the first item n[0]
     * https://www.geeksforgeeks.org/selection-sort/
     * Best,average and worst Case: O(n^2) Space Complexity: O(1)
     * Advantages:
     * in place
     * Disadvantage:
     * O(n^2)
     * Not Stability: a not stable sorting algorithm
     * #LastReview
     * #Review
     * #Idea:
     * 
     */

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            }
            if (minIndex != i)
                swap(nums, i, minIndex);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

}