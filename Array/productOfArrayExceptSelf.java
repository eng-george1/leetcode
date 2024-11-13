package Array;

import java.util.Arrays;

public class productOfArrayExceptSelf {
    /*
     * https://leetcode.com/problems/product-of-array-except-self/description/
     * 238. Product of Array Except Self
     * Given an integer array nums, return an array answer such that answer[i] is
     * equal to the product of all the elements of nums except nums[i].
     * 
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
     * integer.
     * 
     * You must write an algorithm that runs in O(n) time and without using the
     * division operation.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     * Example 2:
     * 
     * Input: nums = [-1,1,0,-3,3]
     * Output: [0,0,9,0,0]
     * 
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 })));
        System.out.println(Arrays.toString(productExceptSelf(new int[] { -1, 1, 0, -3, 3 })));
        System.out.println(Arrays.toString(productExceptSelf(new int[] { 0, 0 })));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes without using the division operation.
     * #Review
     * #Idea:calculate before and after the item
     * the first item and last should be one
     * [1, 2, 3, 4]
     * [1, 1, 2 ,6]//before 1,1*1,1*1*2,1*1*2*3
     * [24,12,4 ,1]//after 1,1*4,1*3*4,1*4*12*2 reverse
     * may have some items with zero value
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;
        // before the item
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        // after the item
        for (int i = suffix.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        // before * after
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = prefix[i] * suffix[i];
        }
        return prefix;
    }

    // space o(1) as result is not count
    public static int[] productExceptSelf0(int[] nums) {
        // The length of the input array
        int length = nums.length;

        // Final answer array to be returned
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the
        // right,
        // so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // For the index 'i', R would contain the
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }

    public static int[] productExceptSelf00(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroCount++;
            else
                product *= nums[i];
        }

        if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)
                    nums[i] = product;
                else
                    nums[i] = 0;
            }
        } else {
            if (zeroCount > 1)
                product = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)
                    nums[i] = product;
                else
                    nums[i] = product / nums[i];
            }
        }
        return nums;
    }

}