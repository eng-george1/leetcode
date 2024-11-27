package BinarySearch;

public class search {
    /*
     * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
     * 81. Search in Rotated Sorted Array II
     * There is an integer array nums sorted in non-decreasing order (not
     * necessarily with distinct values).
     * Before being passed to your function, nums is rotated at an unknown pivot
     * index k (0 <= k < nums.length) such that the resulting array is [nums[k],
     * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For
     * example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become
     * [4,5,6,6,7,0,1,2,4,4].
     * Given the array nums after the rotation and an integer target, return true if
     * target is in nums, or false if it is not in nums.
     * You must decrease the overall operation steps as much as possible.
     * Example 1:
     * Input: nums = [2,5,6,0,0,1,2], target = 0
     * Output: true
     * Example 2:
     * Input: nums = [2,5,6,0,0,1,2], target = 3
     * Output: false
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n) in the worst case because the duplication and O(logn) in best case SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            // If there are duplicates, we can't determine the sorted part; move the left pointer by 1
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) { // Left part is sorted
                // Check if the target lies within the sorted left part
                if (nums[left] <= target && target < nums[mid]) right = mid - 1; // Narrow down to the left part
                else left = mid + 1; // Target is in the unsorted right part
            } else { // Right part is sorted
                // Check if the target lies within the sorted right part
                if (nums[mid] < target && target <= nums[right]) left = mid + 1; // Narrow down to the right part
                else right = mid - 1; // Target is in the unsorted left part
            }
        }
        return false;
    }
}