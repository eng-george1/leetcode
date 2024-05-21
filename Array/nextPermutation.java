package Array;

import java.util.Arrays;

public class nextPermutation {
    /*
     * https://leetcode.com/problems/next-permutation/
     * https://www.youtube.com/watch?v=CjE1wQESlkI&ab_channel=XavierElon
     * 31. Next Permutation
     * A permutation of an array of integers is an arrangement of its members into a
     * sequence or linear order.
     * 
     * For example, for arr = [1,2,3], the following are all the permutations of
     * arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
     * The next permutation of an array of integers is the next lexicographically
     * greater permutation of its integer. More formally, if all the permutations of
     * the array are sorted in one container according to their lexicographical
     * order, then the next permutation of that array is the permutation that
     * follows it in the sorted container. If such arrangement is not possible, the
     * array must be rearranged as the lowest possible order (i.e., sorted in
     * ascending order).
     * 
     * For example, the next permutation of arr = [1,2,3] is [1,3,2].
     * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
     * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does
     * not have a lexicographical larger rearrangement.
     * Given an array of integers nums, find the next permutation of nums.
     * 
     * The replacement must be in place and use only constant extra memory.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,2,3]
     * Output: [1,3,2]
     * Example 2:
     * 
     * Input: nums = [3,2,1]
     * Output: [1,2,3]
     * Example 3:
     * 
     * Input: nums = [1,1,5]
     * Output: [1,5,1]
     * 
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(Arrays.toString(nextPermutation(new int[] { 1, 2, 3 })));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #Review
     * #Idea:start from end and check unitl you find nums[i]<nums[i+1] then scan
     * from end and find first number bigger than the nums[i]
     * swap these and sort from end until i+1 assending by swap
     * 23541==> i=1(3) and first bugger number 4 swap 3 and 4 --> 24531 then sort by
     * swap 531--> 135 then result 24135
     */
    public static int[] nextPermutation(int[] nums) {
        boolean isSwap = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            // 1
            if (nums[i] < nums[i + 1]) {
                // scan to find the first bigger
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[i] < nums[j]) {
                        swap(nums, i, j);
                        for (int ii = nums.length - 1; ii > i / 2; ii--) {
                            swap(nums, ii, i +  nums.length - ii);
                        }
                        return nums;
                    }

                }

            }
        }
        for (int i = nums.length - 1; i >= 0 / 2; i--) {
            swap(nums, i,  nums.length - i);
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}