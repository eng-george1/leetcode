package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import a_Basics.Algorithms.backtracking;

public class subsets {
    /*
     * https://leetcode.com/problems/subsets/description/
     * 78. Subsets
     * Given an integer array nums of unique elements, return all possible
     * subsets
     * (the power set).
     * The solution set must not contain duplicate subsets. Return the solution in
     * any order.
     * Example 1:
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * Example 2:
     * Input: nums = [0]
     * Output: [[],[0]]
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(subsets(new int[] { 1, 2, 3 }));
        System.out.println(subsetsWithDup(new int[] { 1, 2, 2 }));
    }

    /*
     * TC:O(nX2^n) SC: O(nX2^n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    //
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList());
        backTracking(nums, 0, new ArrayList(), result);
        return result;
    }

    private static void backTracking(int[] nums, int start, List<Integer> combination, List<List<Integer>> result) {
        if (combination.size() > 0)
            result.add(new ArrayList<>(combination));
        if (start == nums.length)
            return;
        for (int i = start; i < nums.length; i++) {
            combination.add(nums[i]);
            backTracking(nums, i + 1, combination, result);
            combination.removeLast();
        }
    }

    public static List<List<Integer>> subsets01(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : result) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            result.addAll(newSubsets);
        }
        return result;
    }

    // 90. Subsets II
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList());
        Arrays.sort(nums);
        backTrackingWithDup(nums, 0, new ArrayList(), result);
        return result;
    }

    private static void backTrackingWithDup(int[] nums, int start, List<Integer> combination,
            List<List<Integer>> result) {
        if (combination.size() > 0)
            result.add(new ArrayList<>(combination));
        if (start == nums.length)
            return;
        for (int i = start; i < nums.length; i++) {
            // add this condition and sort the array first
            if (i != start && nums[i] == nums[i - 1])
                continue;
            combination.add(nums[i]);
            backTrackingWithDup(nums, i + 1, combination, result);
            combination.removeLast();
        }
    }
}