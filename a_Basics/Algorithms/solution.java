package a_Basics.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class solution {
    /*
     * https://www.youtube.com/watch?v=bj2Qdu08XYw&ab_channel=AhmedAli
     * 
     * Explore all possible solutions by building incrementally (Permutations)
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] arr = { 1, 2, 3, 4 };
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations2(arr, 0, result);

        // Print all permutations
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
        result = new ArrayList<>();
        generatePermutations(arr, new ArrayList<Integer>(), result);
        // Print all permutations
        for (List<Integer> permutation : result) {
            // System.out.println(permutation);
        }
    }

    /*
     * TC:O(2^n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    // Recursive function to generate all permutations
    private static void generatePermutations(int[] arr, List<Integer> current, List<List<Integer>> result) {
        // Base case: if the current permutation has the same length as the array, add
        // it to result
        if (current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try each element in arr as the next element in the permutation
        for (int i = 0; i < arr.length; i++) {
            // Skip if the element is already in the current permutation
            if (current.contains(arr[i])) {
                continue;
            }

            // Choose the element and add it to the current permutation
            current.add(arr[i]);
            generatePermutations(arr, current, result); // Recurse
            current.remove(current.size() - 1); // Backtrack
        }
    }

    // Recursive function to generate permutations by swapping
    private static void generatePermutations2(int[] arr, int start, List<List<Integer>> result) {
        // Leaf node: add the current permutation when start index reaches end of array
        if (start == arr.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : arr) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        // Swap each element from start index onward to create new permutations
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i); // Choose element i as the next element
            generatePermutations2(arr, start + 1, result); // Recurse to create the next element
            swap(arr, start, i); // Backtrack (undo the swap)
        }
    }

    // Helper method to swap elements in an array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}