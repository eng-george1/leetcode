//package ;

import java.util.PriorityQueue;

public class kSum {
    /*
     * https://leetcode.com/problems/find-the-k-sum-of-an-array/description/
     * 2386. Find the K-Sum of an Array
     * You are given an integer array nums and a positive integer k. You can choose
     * any subsequence of the array and sum all of its elements together.
     * We define the K-Sum of the array as the kth largest subsequence sum that can
     * be obtained (not necessarily distinct).
     * Return the K-Sum of the array.
     * A subsequence is an array that can be derived from another array by deleting
     * some or no elements without changing the order of the remaining elements.
     * Note that the empty subsequence is considered to have a sum of 0.
     * Example 1:
     * Input: nums = [2,4,-2], k = 5
     * Output: 2
     * Explanation: All the possible subsequence sums that we can obtain are the
     * following sorted in decreasing order:
     * - 6, 4, 4, 2, 2, 0, 0, -2.
     * The 5-Sum of the array is 2.
     * Example 2:
     * Input: nums = [1,-2,3,4,-10,12], k = 16
     * Output: 10
     * Explanation: The 16-Sum of the array is 10.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(kSum(new int[]{2,4,-2},5));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static long kSum(int[] nums, int k) {
        long sum = 0;
        PriorityQueue<Integer> pqPositive = new PriorityQueue<>();
        PriorityQueue<Integer> pqNegative = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                sum += nums[i];
                pqPositive.add(nums[i]);
            } else {
                pqNegative.add(nums[i]);
            }
        }
        while ((!pqPositive.isEmpty()||!pqNegative.isEmpty())&&k>0) {
            if(!pqPositive.isEmpty()){
                sum-=pqPositive.poll();
            }
            else{
                sum+=pqNegative.poll();
            }
            k--;
        }
        return sum;
    }
}