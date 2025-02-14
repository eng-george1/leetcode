package TwoPointers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class threeSum {
    /*
     * https://leetcode.com/problems/3sum/description/
     * 15. 3Sum
     * Given an integer array nums, return all the triplets [nums[i], nums[j],
     * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
     * nums[k] == 0.
     * 
     * Notice that the solution set must not contain duplicate triplets.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not
     * matter.
     * Example 2:
     * 
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
     * Example 3:
     * 
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     * Explanation: The only possible triplet sums up to 0.
     * 
     * 
     * Constraints:
     * 
     * 3 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
        System.out.println(threeSum(new int[] { 0, 0, 0 }));
    }

    /*
     * TC:O(n^2) SC: O(1)
     * #Notes
     * #Review
     * #Idea:
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // #Idea: for to len-2 so at least have i+left(i+1)+right(len-1)
        for (int i = 0; i < nums.length - 2; i++) {
            // #Idea:if the number>0 mean all number after is >0 because we sorted so we are
            // sure that will not equal 0 because no negative
            if (nums[i] > 0)
                break;
            // #Idea:this condition to reduce time incase duplicated numbers
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // #Idea: skip all the duplicated
                    while (left < nums.length - 1 && nums[left] == nums[left + 1])
                        left++;
                    while (right > 0 && nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                } else if (total > 0)
                    right--;
                else
                    left++;
            }
        }
        return result;
    }

    // using Hashmap
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // len-2
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            if (nums[i] > 0)
                break;
            // len-1
            for (int j = i + 1; j < nums.length - 1; j++) {

                int required = -1 * (nums[i] + nums[j]);
                if (map.containsKey(required) && map.get(required) > j)
                    result.add(Arrays.asList(nums[i], nums[j], required));
            }
        }
        return result.stream().distinct().toList();
    }

    // without sorting C:O(n^2) SC: O(n)
     public List<List<Integer>> threeSum01(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) if (dups.add(nums[i])) {
            for (int j = i + 1; j < nums.length; ++j) {
                int complement = -nums[i] - nums[j];
                if (seen.containsKey(complement) && seen.get(complement) == i) {
                    List<Integer> triplet = Arrays.asList(
                        nums[i],
                        nums[j],
                        complement
                    );
                    Collections.sort(triplet);
                    res.add(triplet);
                }
                seen.put(nums[j], i);
            }
        }
        return new ArrayList(res);
    }
}