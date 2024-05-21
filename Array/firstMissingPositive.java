package Array;

public class firstMissingPositive {
    /*
     * https://leetcode.com/problems/first-missing-positive/description/
     * 41. First Missing Positive
     * Given an unsorted integer array nums. Return the smallest positive integer
     * that is not present in nums.
     * 
     * You must implement an algorithm that runs in O(n) time and uses O(1)
     * auxiliary space.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,2,0]
     * Output: 3
     * Explanation: The numbers in the range [1,2] are all in the array.
     * Example 2:
     * 
     * Input: nums = [3,4,-1,1]
     * Output: 2
     * Explanation: 1 is in the array but 2 is missing.
     * Example 3:
     * 
     * Input: nums = [7,8,9,11,12]
     * Output: 1
     * Explanation: The smallest positive integer 1 is missing.
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(firstMissingPositive(new int[] { 1, 2, 0 }));
        System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));
        System.out.println(firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
        System.out.println(firstMissingPositive(new int[] { 1 }));
    }

    /*
     * TC:O(3n) SC: O(1)
     * #Notes runs in O(n) time and uses O(1)
     * #Review
     * #Idea: first set all zeros and negative to be value out of the range
     * second remark the visited index with negative
     * get first postive value
     * if not so return the next element after last element in the array
     */
    public static int firstMissingPositive(int[] nums) {
        // set all negative and zeroes with out of range value or any value out of the
        // range
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0)
                nums[i] = nums.length + 1;
        }
        // remark all visited index with -
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) <= nums.length)
                if (nums[Math.abs(nums[i]) - 1] > 0)
                    nums[Math.abs(nums[i]) - 1] = -1 * nums[Math.abs(nums[i]) - 1];
        }
        // check non nrgative value, means it is not visited and it missed
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        // if not so return the next element after last element in the array
        return nums.length + 1;
    }
}