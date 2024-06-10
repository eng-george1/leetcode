package StacksQueues;

import java.util.Stack;

public class largestRectangleArea {
    /*
     * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
     * 84. Largest Rectangle in Histogram
     * Given an array of integers heights representing the histogram's bar height
     * where the width of each bar is 1, return the area of the largest rectangle in
     * the histogram.
     * 
     * Example 1:
     * 
     * Input: heights = [2,1,5,6,2,3]
     * Output: 10
     * Explanation: The above is a histogram where width of each bar is 1.
     * The largest rectangle is shown in the red area, which has an area = 10 units.
     * Example 2:
     * 
     * 
     * Input: heights = [2,4]
     * Output: 4
     * 
     * 
     * Constraints:
     * 
     * 1 <= heights.length <= 105
     * 0 <= heights[i] <= 104
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
        System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 0, 3, 3, 3, 3 }));
        System.out.println(largestRectangleArea(new int[] { 2, 1, 1 }));
        System.out.println(largestRectangleArea(new int[] { 2, 4}));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea: use stack to store the increase values only with its index and if
     * decrease value (the top of the stack > current value )
     * pop from the stack until you found less or equal value and push the current
     * [2,1,5,6,2,3]
     * [2,1,2]
     * https://www.youtube.com/watch?v=zx5Sw9130L0&ab_channel=NeetCode
     */
     // save the item and the index of its effect like [2,1,1] for the first 1 its index 0 not 1  
     public static int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        int ans = 0;
        // push first element
        st.push(new int[] { 0, heights[0] });
        for (int i = 1; i < heights.length; i++) {
            // start index for case like [2,1,2] so one can be from index 0
            int start = i;
            //pop all items that is > current, push only the increase values 
            while (!st.isEmpty() && st.peek()[1] > heights[i]) {
                ans = Math.max(ans, st.peek()[1] * (i - st.peek()[0]));
                start = st.pop()[0];
            }
            // after clear our stack we are sure the value in the stack less or equal to the current
            st.push(new int[] { start, heights[i] });
        }
        while (!st.isEmpty()) {
            ans = Math.max(ans, st.peek()[1] * (heights.length - st.pop()[0]));
        }
        return ans;
    }
    // we are using the index only in the stack but we use the width from the second element in the stack not the one in the top 
    public static int largestRectangleArea1(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        // push first element
        st.push( 0);
        for (int i = 1; i < heights.length; i++) {
            //pop all items that is > current, push only the increase values 
            while (!st.isEmpty() &&heights[ st.peek()] > heights[i]) {
                int height=heights[st.pop()];
                // use the index of the item before the top in the stack
                int width=st.isEmpty()?i:i-st.peek()-1;
                ans = Math.max(ans,height* width);                
            }
            // after clear our stack we are sure the value in the stack less or equal to the current
            st.push(i);
        }
        while (!st.isEmpty()) {
            int height=heights[st.pop()];
            // use the high len if not item in the stack
            int width=st.isEmpty()?heights.length:heights.length-st.peek()-1;
            ans = Math.max(ans,height* width);                
        }
        return ans;
    }
   
   
    // brute force (or naive) solution O(n^2) SC: O(1)
    // Track the start, min item,max area
    public static int largestRectangleArea3(int[] heights) {
        int ans = 0, min = 0;
        for (int i = 0; i < heights.length; i++) {
            min = heights[i];
            ans = Math.max(ans, heights[i]);
            for (int j = i + 1; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                ans = Math.max(ans, min * (j - i + 1));
            }
        }
        return ans;
    }
}