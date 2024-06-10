package FamousAlgs;

import a_Basics.stack;

public class maxSubArray {
    /*
     * https://leetcode.com/problems/maximum-subarray/description/
     * 53. Maximum Subarray
     * Given an integer array nums, find the
     * subarray
     * with the largest sum, and return its sum.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     * Example 2:
     * 
     * Input: nums = [1]
     * Output: 1
     * Explanation: The subarray [1] has the largest sum 1.
     * Example 3:
     * 
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
     * 
     * 
     * Constraints:
     * 
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 
     * 
     * Follow up: If you have figured out the O(n) solution, try coding another
     * solution using the divide and conquer approach, which is more subtle.
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[]{-1,-2}));
        System.out.println(maxSubArray(new int[]{1,3,-3,1}));
    }

    /*
     * TC:O(n) SC: O(1)
     * #Notes
     * #Idea:
     * [-1,-2]
     * [1,3,-4]
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0], current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current=Math.max(current+nums[i],nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }
}