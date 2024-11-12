package PrefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class countTriplets {
    /*
     * https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-
     * equal-xor/description/
     * 1442. Count Triplets That Can Form Two Arrays of Equal XOR
     * Given an array of integers arr.
     * We want to select three indices i, j and k where (0 <= i < j <= k <
     * arr.length).
     * Let's define a and b as follows:
     * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
     * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
     * Note that ^ denotes the bitwise-xor operation.
     * Return the number of triplets (i, j and k) Where a == b.
     * Example 1:
     * Input: arr = [2,3,1,6,7]
     * Output: 4
     * Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
     * Example 2:
     * Input: arr = [1,1,1,1,1]
     * Output: 10
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(countTriplets(new int[] { 2, 3, 1, 6, 7 }));
        System.out.println(countTriplets(new int[] { 1, 1, 1, 1, 1 }));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:arr[i]⊕arr[i+1]⊕…⊕arr[j−1]⊕arr[j]⊕arr[j+1]⊕…⊕arr[k]=0
     * If we let X(i,k) be the XOR of elements from i to k:
     * X(i,k)=0
     * This means if the total XOR from i to k is zero, then any j between i and k
     * (inclusive) create a triplet with i and k that satisfies a=b.
     */
    public static int countTriplets(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        int[] prefix = new int[n + 1];
        System.arraycopy(arr, 0, prefix, 1, n);

        for (int i = 1; i <= n; i++)
            prefix[i] ^= prefix[i - 1];

        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (prefix[i] == prefix[j]) {
                    cnt += (j - i - 1);
                }
            }
        }

        return cnt;
    }

    // O(n)
    public int countTriplets1(int[] arr) {
        int size = arr.length;
        int count = 0;
        int prefix = 0;

        // Maps to store counts and totals of XOR values encountered
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        Map<Integer, Integer> totalMap = new HashMap<>();

        // Iterating through the array
        for (int i = 0; i < size; ++i) {
            // Calculating XOR prefix
            prefix ^= arr[i];

            // Calculating contribution of current element to the result
            count += countMap.getOrDefault(prefix, 0) * i -
                    totalMap.getOrDefault(prefix, 0);

            // Updating total count of current XOR value
            totalMap.put(prefix, totalMap.getOrDefault(prefix, 0) + i + 1);
            countMap.put(prefix, countMap.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }
}