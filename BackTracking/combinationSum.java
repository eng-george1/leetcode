package BackTracking;

import java.util.*;

import Graph.numIslands;

public class combinationSum {
    /*
     * https://leetcode.com/problems/combination-sum/description/
     * 39. Combination Sum
     * Given an array of distinct integers candidates and a target integer target,
     * return a list of all unique combinations of candidates where the chosen
     * numbers sum to target. You may return the combinations in any order.
     * The same number may be chosen from candidates an unlimited number of times.
     * Two combinations are unique if the
     * frequency
     * of at least one of the chosen numbers is different.
     * The test cases are generated such that the number of unique combinations that
     * sum up to target is less than 150 combinations for the given input.
     * Example 1:
     * Input: candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3],[7]]
     * Explanation:
     * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
     * times.
     * 7 is a candidate, and 7 = 7.
     * These are the only two combinations.
     * Example 2:
     * Input: candidates = [2,3,5], target = 8
     * Output: [[2,2,2,2],[2,3,3],[3,5]]
     * Example 3:
     * Input: candidates = [2], target = 1
     * Output: []
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));

        System.out.println(combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    // O(n^m) O(m) n array len and m is the target
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        backtrack(target, new ArrayList(), 0, candidates, results);
        return results;
    }

    protected static void backtrack(int remain, List<Integer> combinations, int start, int[] candidates,
            List<List<Integer>> results) {
        if (remain == 0) {
            // make a deep copy of the current combination
            results.add(new ArrayList<Integer>(combinations));
            return;
        } else if (remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }
        // exclude item did before to prevent duplication in result with diff order
        for (int i = start; i < candidates.length; ++i) {
            // add the number into the combination
            combinations.add(candidates[i]);
            backtrack(remain - candidates[i], combinations, i, candidates, results);
            // backtrack, remove the number from the combination
            combinations.removeLast();
        }
    }

    // more slow
    public List<List<Integer>> combinationSum01(int[] candidates, int target) {
        List<List<Integer>>[] dp = new List[target + 1];
        for (int i = 0; i <= target; i++)
            dp[i] = new ArrayList<>();
        dp[0].add(new ArrayList<>());
        for (int candidate : candidates) {
            for (int j = candidate; j <= target; j++) {
                for (List<Integer> comb : dp[j - candidate]) {
                    List<Integer> newComb = new ArrayList(comb);
                    newComb.add(candidate);
                    dp[j].add(newComb);
                }
            }
        }
        return dp[target];
    }

    // we can use updown backtracking
    public static List<List<Integer>> combinationSumUp(int[] candidates, int target) {
        return backtrackUp(target, new ArrayList<>(), 0, candidates);
    }

    private static List<List<Integer>> backtrackUp(int remain, List<Integer> comb, int start, int[] candidates) {
        List<List<Integer>> result = new ArrayList<>();

        if (remain == 0) {
            result.add(new ArrayList<>(comb));
            return result;
        } else if (remain < 0) {
            return result; // Return empty result list
        }

        for (int i = start; i < candidates.length; ++i) {
            comb.add(candidates[i]);
            result.addAll(backtrackUp(remain - candidates[i], comb, i, candidates));
            comb.remove(comb.size() - 1);
        }
        return result;
    }

    // 40. Combination Sum II
    // O(n^m) O(m) n array len and m is the target
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack2(target, new ArrayList(), 0, candidates, results);
        return results;
    }

    protected static void backtrack2(int remain, List<Integer> combinations, int start, int[] candidates,
            List<List<Integer>> results) {
        if (remain == 0) {
            // make a deep copy of the current combination
            results.add(new ArrayList<Integer>(combinations));
            return;
        } else if (remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }
        // exclude item did before to prevent duplication in result with diff order
        for (int i = start; i < candidates.length; ++i) {
            if (i != start && candidates[i] == candidates[i - 1])
                continue;
            // add the number into the combination
            combinations.add(candidates[i]);
            backtrack2(remain - candidates[i], combinations, i + 1, candidates, results);
            // backtrack, remove the number from the combination
            combinations.removeLast();
        }
    }
}