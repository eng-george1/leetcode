//package ;
package Integer;

import java.util.Arrays;
import java.util.HashSet;

public class minimumOperations {
    /*
     * https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
     * 2357. Make Array Zero by Subtracting Equal Amounts
     * You are given a non-negative integer array nums. In one operation, you must:
     * Choose a positive integer x such that x is less than or equal to the smallest
     * non-zero element in nums.
     * Subtract x from every positive element in nums.
     * Return the minimum number of operations to make every element in nums equal
     * to 0.
     * Example 1:
     * Input: nums = [1,5,0,3,5]
     * Output: 3
     * Explanation:
     * In the first operation, choose x = 1. Now, nums = [0,4,0,2,4].
     * In the second operation, choose x = 2. Now, nums = [0,2,0,0,2].
     * In the third operation, choose x = 2. Now, nums = [0,0,0,0,0].
     * Example 2:
     * Input: nums = [0]
     * Output: 0
     * Explanation: Each element in nums is already 0 so no operations are needed.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(minimumOperations(new int[] { 1, 5, 0, 3, 5 }));
        System.out.println(minimumOperations(new int[] { 2, 5, 1, 3, 4 }));
        System.out.println(minimumOperations(new int[] { 0 }));
        System.out.println(minimumOperations(new int[] { 1 }));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        int count = 0;
        for (int integer : nums) {
            if (!set.contains(integer)) {
                count++;
                set.add(integer);
            }
        }
        return count;
    }

    public static int minimumOperations2(int[] nums) {
        boolean[] s = new boolean[101];
        s[0] = true;
        int ans = 0;
        for (int x : nums) {
            if (!s[x]) {
                ++ans;
                s[x] = true;
            }
        }
        return ans;
    }

}