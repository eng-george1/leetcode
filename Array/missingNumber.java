package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class missingNumber {
    /*
     * https://leetcode.com/problems/missing-number/editorial/
     * 268. Missing Number
     * Given an array nums containing n distinct numbers in the range [0, n], return
     * the only number in the range that is missing from the array.
     * Example 1:
     * Input: nums = [3,0,1]
     * Output: 2
     * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range
     * [0,3]. 2 is the missing number in the range since it does not appear in nums.
     * Example 2:
     * Input: nums = [0,1]
     * Output: 2
     * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range
     * [0,2]. 2 is the missing number in the range since it does not appear in nums.
     * Example 3:
     * Input: nums = [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range
     * [0,9]. 8 is the missing number in the range since it does not appear in nums.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    // sort
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }

        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i - 1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }

        // Array was not missing any numbers
        return -1;
    }

    // Hashset
    public static int missingNumber01(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums)
            numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    // Bit Manipulation
    /*
     * Because we know that nums contains n numbers and that it is missing
     * exactly one number on the range [0..n−1], we know that n definitely
     * replaces the missing number in nums. Therefore, if we initialize an integer
     * to n and XOR it with every index and value, we will be left with the
     * missing number.
     */
    public static int missingNumber02(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    // Gauss' Formula
    public static int missingNumber03(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;// Gauss' Formula
        int actualSum = 0;
        for (int num : nums)
            actualSum += num;
        return expectedSum - actualSum;
    }
}