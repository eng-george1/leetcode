package BinarySearch;

public class findMinimumRotatedSortedArray {
    /*
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
     * description/
     * Suppose an array of length n sorted in ascending order is rotated between 1
     * and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
     * 
     * [4,5,6,7,0,1,2] if it was rotated 4 times.
     * [0,1,2,4,5,6,7] if it was rotated 7 times.
     * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
     * in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
     * 
     * Given the sorted rotated array nums of unique elements, return the minimum
     * element of this array.
     * 
     * You must write an algorithm that runs in O(log n) time.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [3,4,5,1,2]
     * Output: 1
     * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
     * Example 2:
     * 
     * Input: nums = [4,5,6,7,0,1,2]
     * Output: 0
     * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4
     * times.
     * Example 3:
     * 
     * Input: nums = [11,13,15,17]
     * Output: 11
     * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
     * 
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(findMin(new int[] { 2, 3, 4, 5, 0, 1 }));
        System.out.println(findMin(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(findMin(new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 1 }));
        System.out.println(findMin(new int[] { 1, 2 }));

    }

    /*
     * TC:O(log n) SC: O(1)
     * #Notes we have left and right , find which one is not sorted and take it
     * check if the value is changed from big to small or from small to big
     * #Review
     */
    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        while (right >= left) {
            int mid = left + (right - left) / 2;

            // if the mid element is greater than its next element then mid+1 element is the
            // smallest
            // This point would be the point of change. From higher to lower value.
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // if the mid element is lesser than its previous element then mid element is
            // the smallest
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // if the mid elements value is greater than the 0th element this means
            // the least value is still somewhere to the right as we are still dealing with
            // elements
            // greater than nums[0]
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                // if nums[0] is greater than the mid value then this means the smallest value
                // is somewhere to
                // the left
                right = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int findMin01(int[] nums) {
        // if one return it
        // if two return min
        // if dsorted return first element
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.min(nums[0], nums[1]);
        if (nums[0] < nums[nums.length - 1])
            return nums[0];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1])
                return nums[mid];
            if (mid + 1 <= nums.length - 1 && nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            // add <= incase one item
            if (mid - 1 >= 0 && nums[left] <= nums[mid - 1])// sorted, chose the other side
                left = mid + 1;
            else
                right = mid - 1;
        }
        return nums[0];
    }
}