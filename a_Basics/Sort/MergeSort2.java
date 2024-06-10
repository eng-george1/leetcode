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

     */
   
    // bottom-up merge sort
    // Method to sort an array using merge sort
    private static void mergeSort2(int[] nums) {
        for (int size = 1; size < nums.length; size *= 2) {
            for (int i = 0; i < nums.length - size; i += 2 * size) {
                int mid = i + size - 1;
                int end = Math.min(i + 2 * size - 1, nums.length - 1);
                merge2(nums, i, mid, end);
            }
        }
    }
    private static void merge2(int[] nums, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid || j <= r) {
            if (i > mid || j <= r && nums[i] > nums[j]) {
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }
        System.arraycopy(tmp, 0, nums, l, r - l + 1);
    }

}