package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class solution {
    /*
     * https://leetcode.com/problems/top-k-frequent-elements/description/
     * 347. Top K Frequent Elements
     * Given an integer array nums and an integer k, return the k most frequent
     * elements. You may return the answer in any order.
     * Example 1:
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     * Input: nums = [1], k = 1
     * Output: [1]
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:O(nlogk) SC: O(n+k)
     */
    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }
        // 1. Build hash map: character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2));
        // 2. Keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        // 3. Build an output array
        // O(k log k) time
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    // O(n)O(n)
    public int[] topKFrequent01(int[] nums, int k) {
        // Step 1: Find the maximum and minimum elements in the array
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }
        // Step 2: Create an array to count the frequency of each element
        int[] freq = new int[max - min + 1];
        for (int n : nums) {
            freq[n - min]++;
        }
        // Step 3: Create an array of lists where index represents the frequency
        ArrayList<Integer>[] freqArr = new ArrayList[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                if (freqArr[freq[i]] == null) {
                    freqArr[freq[i]] = new ArrayList<>();
                }
                freqArr[freq[i]].add(i + min);
            }
        }
        // Step 4: Gather the top k frequent elements from the frequency array
        int[] res = new int[k];
        int kk = 0;
        for (int i = freqArr.length - 1; i >= 0; i--) {
            if (freqArr[i] != null) {
                for (int j = 0; j < freqArr[i].size(); j++) {
                    res[kk] = freqArr[i].get(j);
                    kk++;
                    // If we have collected k elements, return the result
                    if (kk >= k) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
}
