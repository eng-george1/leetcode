package Array;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {
    /*
     * https://leetcode.com/problems/longest-consecutive-sequence/description/
     * 128. Longest Consecutive Sequence
     * Given an unsorted array of integers nums, return the length of the longest
     * consecutive elements sequence.
     * You must write an algorithm that runs in O(n) time.
     * Example 1:
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
     * Therefore its length is 4.
     * Example 2:
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
     * Output: 9
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n) SC: O(1)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (int num : nums) {
            // Only start a sequence if the current number is the smallest in the sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;
                while (set.contains(currentNum + 1)) {
                    currentLen++;
                    currentNum++;
                }
                maxLen = Math.max(maxLen, currentLen);
            }
        }
        return maxLen;
    }
}