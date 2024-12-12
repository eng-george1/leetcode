package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Array.printPermutations;
import a_Basics.Algorithms.backtracking;

public class permute {
    /*
     * https://leetcode.com/problems/permutations/description/
     * 46. Permutations
     * Given an array nums of distinct integers, return all the possible
     * permutations
     * . You can return the answer in any order.
     * Example 1:
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * Example 2:
     * Input: nums = [0,1]
     * Output: [[0,1],[1,0]]
     * Example 3:
     * Input: nums = [1]
     * Output: [[1]]
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(permute(new int[] { 1, 2, 3 }));

        System.out.println(permuteUnique(new int[] { 1, 1, 2 }));
    }

    /*
     * 
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:O(nXn!) SC: O(n) if not count the result
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking(nums, new ArrayList(), result);
        return result;
    }

    private static void backTracking(int[] nums, List<Integer> combination, List<List<Integer>> result) {
        if (combination.size() == nums.length) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // to not duplicate the current, we can use boolean[]
            if (combination.contains(nums[i]))
                continue;
            combination.add(nums[i]);
            backTracking(nums, combination, result);
            combination.removeLast();
        }
    }

    public List<List<Integer>> permute01(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutations(ans, nums, 0);
        return ans;
    }

    public void permutations(List<List<Integer>> ans, int[] nums, int ind) {
        if (ind == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            ans.add(list);
            return;
        }
        for (int i = ind; i < nums.length; i++) {
            swap(nums, i, ind);
            permutations(ans, nums, ind + 1);
            swap(nums, i, ind);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void per(List<List<Integer>> ans, List<Integer> list, boolean[] bool, int[] arr) {
        if (list.size() == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // add this to not use contains
            if (!bool[i]) {
                list.add(arr[i]);
                bool[i] = true;
                per(ans, list, bool, arr);
                list.remove(list.size() - 1);
                bool[i] = false;
            }
        }
    }

    // 47. Permutations II
    // O(nXn!) O(n) if not count the result or you can say O(nXn!)
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backTrackingUnique(nums, new boolean[nums.length], new ArrayList(), result);
        return result;
    }

    private static void backTrackingUnique(int[] nums, boolean[] used, List<Integer> combination,
            List<List<Integer>> result) {
        if (combination.size() == nums.length) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // to not duplicate the current
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                continue;
            combination.add(nums[i]);
            used[i] = true;
            backTrackingUnique(nums, used, combination, result);
            used[i] = false;
            combination.removeLast();
        }
    }
}