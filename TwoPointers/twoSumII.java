package TwoPointers;

import java.util.Arrays;
import java.util.HashMap;

public class twoSumII {
    /*
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
     * 167. Two Sum II - Input Array Is Sorted
     * Given a 1-indexed array of integers numbers that is already sorted in
     * non-decreasing order, find two numbers such that they add up to a specific
     * target number. Let these two numbers be numbers[index1] and numbers[index2]
     * where 1 <= index1 < index2 <= numbers.length.
     * 
     * Return the indices of the two numbers, index1 and index2, added by one as an
     * integer array [index1, index2] of length 2.
     * 
     * The tests are generated such that there is exactly one solution. You may not
     * use the same element twice.
     * 
     * Your solution must use only constant extra space.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We
     * return [1, 2].
     * Example 2:
     * 
     * Input: numbers = [2,3,4], target = 6
     * Output: [1,3]
     * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We
     * return [1, 3].
     * Example 3:
     * 
     * Input: numbers = [-1,0], target = -1
     * Output: [1,2]
     * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We
     * return [1, 2].
     * 
     * 
     * Constraints:
     * 
     * 2 <= numbers.length <= 3 * 104
     * -1000 <= numbers[i] <= 1000
     * numbers is sorted in non-decreasing order.
     * -1000 <= target <= 1000
     * The tests are generated such that there is exactly one solution.
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * Your solution must use only constant extra space.
     * #Review
     * #Idea:two pointers and if sum>target move righ pointer
     * This will work perefct for sorted
     */
    public static int[] twoSum(int[] numbers, int target) {
        int lIn = 0, rIn = numbers.length - 1;
        while (rIn > lIn) {
            if (numbers[rIn] + numbers[lIn] == target)
                return new int[] { lIn + 1, rIn + 1 };
            if (numbers[rIn] + numbers[lIn] > target)
                rIn--;
            else
                lIn++;
        }
        return new int[] { -1, -1 };
    }

    // #Idea:use hashmap and put the complementary(target-number[i])
    // this is perefct solution for unsorted
    public static int[] twoSum1(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i]))
                return new int[] { map.get(numbers[i]) + 1, i + 1 };
            map.put(target - numbers[i], i);
        }
        return new int[] { -1, -1 };
    }
}