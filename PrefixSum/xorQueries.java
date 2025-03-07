package PrefixSum;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class xorQueries {
    /*
     * https://leetcode.com/problems/xor-queries-of-a-subarray/description/
     * 1310. XOR Queries of a Subarray
     * You are given an array arr of positive integers. You are also given the array
     * queries where queries[i] = [lefti, righti].
     * For each query i compute the XOR of elements from lefti to righti (that is,
     * arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).
     * Return an array answer where answer[i] is the answer to the ith query.
     * Example 1:
     * Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
     * Output: [2,7,14,8]
     * Explanation:
     * The binary representation of the elements in the array are:
     * 1 = 0001
     * 3 = 0011
     * 4 = 0100
     * 8 = 1000
     * The XOR values for queries are:
     * [0,1] = 1 xor 3 = 2
     * [1,2] = 3 xor 4 = 7
     * [0,3] = 1 xor 3 xor 4 xor 8 = 14
     * [3,3] = 8
     * Example 2:
     * Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
     * Output: [8,0,4,4]
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] arr = { 1, 3, 4, 8 };
        int[][] queries = { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 3 } };

        // Running the function with the test input
        int[] result = xorQueries(arr, queries);
        System.out.println("Output: " + Arrays.toString(result));

        int[] arr1 = { 16 };
        int[][] queries1 = {{0,0},{0,0},{0,0} };

        // Running the function with the test input
        int[] result1 = xorQueries(arr1, queries1);
        System.out.println("Output: " + Arrays.toString(result1));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length + 1];
        System.arraycopy(arr, 0, prefix, 1, arr.length);
        for (int i = 1; i <= arr.length; i++)
            prefix[i] ^= prefix[i - 1];

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = prefix[queries[i][0]] ^ prefix[queries[i][1] + 1];
        }
        return result;
    }
}