package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class printPermutations {
    /*
     * Concept
     * https://www.youtube.com/watch?v=TnZHaH9i6-0&ab_channel=AI-PoweredCoder
     * https://www.youtube.com/watch?v=RnGORu7ihkA&t=373s&ab_channel=
     * RitambharaCodingandSystemDesignInterviews
     * print if last
     * for
     * swap
     * call
     * swap
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        List<int[]> result = printAll(new int[] { 1, 2, 3 }, 0, new ArrayList<>());
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }

    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #Review
     * #Idea:Concept
     */
    public static List<int[]> printAll(int[] arr, int cin, List<int[]> result) {

        if (cin > arr.length - 1) {
             System.out.println(Arrays.toString(arr));
            // #Notes: should use clone
            result.add(arr.clone());
        }
        for (int i = cin; i < arr.length; i++) {
            // swap
            swap(arr, i, cin);
            // recurtion
            printAll(arr, cin + 1, result);
            // swap again
            swap(arr, i, cin);
        }
        return result;
    }

    public static void swap(int[] arr, int i, int cin) {
        int temp = arr[i];
        arr[i] = arr[cin];
        arr[cin] = temp;
    }
}