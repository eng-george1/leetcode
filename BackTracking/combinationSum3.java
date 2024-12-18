package BackTracking;

import java.util.ArrayList;
import java.util.List;

import Array.printPermutations;

public class combinationSum3 {
    /*
     * https://leetcode.com/problems/combination-sum-iii/description/
     * 216. Combination Sum III
     * Find all valid combinations of k numbers that sum up
     * to n such that the following conditions are true:
     * Only numbers 1 through 9 are used.
     * Each number is used at most once.
     * Return a list of all possible valid combinations. The list must not contain
     * the same combination twice, and the combinations may be returned in any
     * order.
     * Example 1:
     * Input: k = 3, n = 7
     * Output: [[1,2,4]]
     * Explanation:
     * 1 + 2 + 4 = 7
     * There are no other valid combinations.
     * Example 2:
     * Input: k = 3, n = 9
     * Output: [[1,2,6],[1,3,5],[2,3,4]]
     * Explanation:
     * 1 + 2 + 6 = 9
     * 1 + 3 + 5 = 9
     * 2 + 3 + 4 = 9
     * There are no other valid combinations.
     * Example 3:
     * Input: k = 4, n = 1
     * Output: []
     * Explanation: There are no valid combinations.
     * Using 4 different numbers in the range [1,9], the smallest sum we can get is
     * 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(combinationSum3(3,7));
        System.out.println(combinationSum3(3,9));
    }

    /*
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:Time complexity: O(K×C(9,K)) S:O(K)
     * C(9,k) =9!/(k!(9-k)!)
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private static void backTracking(int k, int n, int start, List<Integer> combinations, List<List<Integer>> result) {
        if (combinations.size() == k && n == 0) {
            result.add(new ArrayList<>(combinations));
            return;
        }
        if (combinations.size() > k || n < 0)
            return;
        for (int i = start; i < 10; i++) {
            combinations.add(i);
            backTracking(k, n-i, i + 1, combinations, result);
            combinations.removeLast();
        }

    }
}