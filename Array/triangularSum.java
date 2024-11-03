package Array;
public class triangularSum {
    /*
     * https://leetcode.com/problems/find-triangular-sum-of-an-array/description/
     * 2221. Find Triangular Sum of an Array
     * You are given a 0-indexed integer array nums, where nums[i] is a digit
     * between 0 and 9 (inclusive).
     * The triangular sum of nums is the value of the only element present in nums
     * after the following process terminates:
     * Let nums comprise of n elements. If n == 1, end the process. Otherwise,
     * create a new 0-indexed integer array newNums of length n - 1.
     * For each index i, where 0 <= i < n - 1, assign the value of newNums[i] as
     * (nums[i] + nums[i+1]) % 10, where % denotes modulo operator.
     * Replace the array nums with newNums.
     * Repeat the entire process starting from step 1.
     * Return the triangular sum of nums.
     * Example 1:
     * Input: nums = [1,2,3,4,5]
     * Output: 8
     * Explanation:
     * The above diagram depicts the process from which we obtain the triangular sum
     * of the array.
     * Example 2:
     * Input: nums = [5]
     * Output: 5
     * Explanation:
     * Since there is only one element in nums, the triangular sum is the value of
     * that element itself.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(triangularSum(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(triangularSum(new int[] { 5 }));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static int triangularSum(int[] nums) {
        int index = nums.length-1;
        while (index > 0) {
            for (int i = 0; i < index; i++) {
                nums[i]=(nums[i]+nums[i+1])%10;
            }
            index--;
        }
        return nums[0];
    }
}