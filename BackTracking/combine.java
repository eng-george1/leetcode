package BackTracking;

import java.util.ArrayList;
import java.util.List;

import Array.printPermutations;
import a_Basics.Algorithms.backtracking;

public class combine {
    /*
     * https://leetcode.com/problems/combinations/description/
     * 77. Combinations
     * Given two integers n and k, return all possible combinations of k numbers
     * chosen from the range [1, n].
     * You may return the answer in any order.
     * Example 1:
     * Input: n = 4, k = 2
     * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
     * Explanation: There are 4 choose 2 = 6 total combinations.
     * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to
     * be the same combination.
     * Example 2:
     * Input: n = 1, k = 1
     * Output: [[1]]
     * Explanation: There is 1 choose 1 = 1 total combination.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(combine(4, 2));
    }

    /*
     * 
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:O(kX(n!/(k!(n-k)!))) SC: O(k)
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private static void backtracking(int n, int k, int start, List<Integer> combinations, List<List<Integer>> result) {
        if (combinations.size() == k) {
            result.add(new ArrayList<>(combinations));
            return;
        }
        for (int i = start; i <= n; i++) {
            combinations.add(i);
            backtracking(n, k, i + 1, combinations, result);
            combinations.removeLast();
        }
    }
}