package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Array.printPermutations;
import a_Basics.Algorithms.backtracking;

public class combinationSum2 {
    /*
     * https://leetcode.com/problems/combination-sum-ii/description/
     * 40. Combination Sum II
     * Given a collection of candidate numbers (candidates) and a target number
     * (target), find all unique combinations in candidates where the candidate
     * numbers sum to target.
     * Each number in candidates may only be used once in the combination.
     * Note: The solution set must not contain duplicate combinations.
     * Example 1:
     * Input: candidates = [10,1,2,7,6,1,5], target = 8
     * Output:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * Example 2:
     * Input: candidates = [2,5,2,1,2], target = 5
     * Output:
     * [
     * [1,2,2],
     * [5]
     * ]
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
    }

    /*
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:O(2^n) SC: O(n)
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backTracking(int[] candidates, int target, int start, List<Integer> combinations,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combinations));
            return;
        }
        if (target < 0)
            return;
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1])
                continue;
            // just enhance
            if (candidates[i] > target)
                break;
            combinations.add(candidates[i]);
            backTracking(candidates, target - candidates[i], i + 1, combinations, result);
            combinations.removeLast();
        }
    }
}