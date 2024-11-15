package TwoPointers;

public class trap {
    /*
     * https://leetcode.com/problems/trapping-rain-water/
     * 42. Trapping Rain Water
     * Given n non-negative integers representing an elevation map where the width
     * of each bar is 1, compute how much water it can trap after raining.
     * Example 1:
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section) is represented by array
     * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section)
     * are being trapped.
     * Example 2:
     * Input: height = [4,2,0,3,2,5]
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
     * #Idea: two pointer and calculate max bar on that side  
     */
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                left_max = Math.max(left_max, height[left]);
                ans += left_max - height[left];
                ++left;
            } else {
                right_max = Math.max(right_max, height[right]);
                ans += right_max - height[right];
                --right;
            }
        }
        return ans;
    }

    // brute force solution with O(n^2)
    public int trap01(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int left_max = 0, right_max = 0;
            // Search the left part for max bar size
            for (int j = i; j >= 0; j--) {
                left_max = Math.max(left_max, height[j]);
            }
            // Search the right part for max bar size
            for (int j = i; j < size; j++) {
                right_max = Math.max(right_max, height[j]);
            }
            ans += Math.min(left_max, right_max) - height[i];
        }
        return ans;
    }
}