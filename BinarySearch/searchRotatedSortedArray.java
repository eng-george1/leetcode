package BinarySearch;

public class searchRotatedSortedArray {
    /*
     * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
     * There is an integer array nums sorted in ascending order (with distinct
     * values).
     * 
     * Prior to being passed to your function, nums is possibly rotated at an
     * unknown pivot index k (1 <= k < nums.length) such that the resulting array is
     * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
     * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
     * and become [4,5,6,7,0,1,2].
     * 
     * Given the array nums after the possible rotation and an integer target,
     * return the index of target if it is in nums, or -1 if it is not in nums.
     * 
     * You must write an algorithm with O(log n) runtime complexity.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     * 
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * Example 3:
     * 
     * Input: nums = [1], target = 0
     * Output: -1
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(search(new int[] { 2, 3, 4, 5, 1 }, 5));
    }

    /*
     * TC:O(log n) SC: O(1)
     * #Notes we have left and right , find which one is sorted and
     * check if the traget is between this range if not select the not sorted one
     * #Review
     */
    public static int search(int[] nums, int target) {
        int startI = 0, endI = nums.length - 1;
        while (startI <= endI) {
            int mid = startI + (endI - startI) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[startI] <= nums[mid])// is left sorted by first item
            // less than or equal last item
            {
                // if the target within the sorted
                if (target >= nums[startI] && target < nums[mid]) {
                    endI = mid - 1;
                } else {
                    startI = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[endI]) {
                    startI = mid + 1;
                } else {
                    endI = mid - 1;
                }
            }

        }
        return -1;
    }
}