package Array;

import java.util.ArrayList;
import java.util.List;

public class findDuplicatesArray {
    /*
     * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
     * 442. Find All Duplicates in an Array
     * 
     * Given an integer array nums of length n where all the integers of nums are in
     * the range [1, n] and each integer appears once or twice, return an array of
     * all the integers that appears twice.
     * 
     * You must write an algorithm that runs in O(n) time and uses only constant
     * extra space.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [4,3,2,7,8,2,3,1]
     * Output: [2,3]
     * Example 2:
     * 
     * Input: nums = [1,1,2]
     * Output: [1]
     * Example 3:
     * 
     * Input: nums = [1]
     * Output: []
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes uses only constant extra space
     * #Review
     * #Idea:use the item -1 as index and remark this index with - sign and if you
     * found - sign this mean this number is used before
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0)
                result.add(Math.abs(nums[i]));
            else
                nums[Math.abs(nums[i]) - 1] = -1 * nums[Math.abs(nums[i]) - 1];
        }
        return result;
    }
}