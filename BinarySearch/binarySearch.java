package BinarySearch;

public class binarySearch {
    /*
     * https://leetcode.com/problems/binary-search/description/
     * Given an array of integers nums which is sorted in ascending order, and an
     * integer target, write a function to search target in nums. If target exists,
     * then return its index. Otherwise, return -1.
     * 
     * You must write an algorithm with O(log n) runtime complexity.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [-1,0,3,5,9,12], target = 9
     * Output: 4
     * Explanation: 9 exists in nums and its index is 4
     * Example 2:
     * 
     * Input: nums = [-1,0,3,5,9,12], target = 2
     * Output: -1
     * Explanation: 2 does not exist in nums so return -1
     * 
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(search(new int[] { 1, 2, 3, 4, 5 }, 5));
    }

    /*
     * TC:O(log n) SC: O(1)
     * #Notes //index should be +startI
     * 
     */
    public static int search(int[] nums, int target) {
        int startI = 0, endI = nums.length;
        while (startI <= endI) {
            if (nums[startI + (endI - startI) / 2] == target)
                return startI + (endI - startI) / 2;
            if (nums[startI + (endI - startI) / 2] > target) {
                endI = startI + (endI - startI) / 2;
            } else {
                startI = startI + (endI - startI) / 2 + 1;
            }
        }
        return -1;
    }

    public static int search01(int[] nums, int target) {
        int i = nums.length / 2;
        int startI = 0, endI = nums.length;
        while (i >= startI && i < endI) {
            if (nums[i] == target)
                return i;
            if (nums[i] > target) {
                endI = i;
            } else {
                startI = i + 1;
            }
            // index should be +startI
            i = (startI + (endI - startI) / 2);
        }
        return -1;
    }
}