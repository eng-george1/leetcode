package a_Basics.Algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PrefixSum {
    /*
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] prefix = calculatePrefixSum(arr);
        System.out.print("Prefix Sum Array: ");
        for (int sum : prefix) {
            System.out.print(sum + " ");
        }
        System.out.println();
        System.out.println("Sum of range (1, 3): " + rangeSum(prefix, 1, 3)); // Output: 9
        System.out.println("Sum of range (0, 4): " + rangeSum(prefix, 0, 4)); // Output: 15

         List<Integer> arr1 = Arrays.asList(1, 2, 3, -1, 4);
        int target = 3;
        int result = subarraySumTotal(arr1, target);
        System.out.println("Number of subarrays with sum " + target + ": " + result); // Expected output depends on the input

    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static int[] calculatePrefixSum(int[] arr) {
        int[] prefix = new int[arr.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix[i+1] = prefix[i] + arr[i];
        }
        return prefix;
    }

    public static int rangeSum(int[] prefix, int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    public static List<Integer> subarraySum(List<Integer> arr, int target) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        // prefix_sum 0 happens when we have an empty array
        prefixSums.put(0, 0);
        int curSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            curSum += arr.get(i);
            int complement = curSum - target;
            if (prefixSums.containsKey(complement)) {
                return List.of(prefixSums.get(complement), i + 1);
            }
            prefixSums.put(curSum, i + 1);
        }
        return null;
    }

     public static int subarraySumTotal(List<Integer> arr, int target) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1); // since empty array's sum is 0
        int curSum = 0;
        int count = 0;
        for (int val : arr) {
            curSum += val;
            int complement = curSum - target;
            if (prefixSums.containsKey(complement)) {
                count += prefixSums.get(complement);
            }
            if (prefixSums.containsKey(curSum)) {
                prefixSums.replace(curSum, prefixSums.get(curSum) + 1);
            } else {
                prefixSums.put(curSum, 1);
            }
        }
        return count;
    }


}