package StacksQueues;

import java.util.HashMap;
import java.util.Stack;

public class longestValidParentheses {
    /*
     * https://leetcode.com/problems/longest-valid-parentheses/description/
     * 32. Longest Valid Parentheses
     * 
     * Given a string containing just the characters '(' and ')', return the length
     * of the longest valid (well-formed) parentheses
     * substring
     * .
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()".
     * Example 2:
     * 
     * Input: s = ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()".
     * Example 3:
     * 
     * Input: s = ""
     * Output: 0
     * 
     * 
     * Constraints:
     * 
     * 0 <= s.length <= 3 * 104
     * s[i] is '(', or ')'.
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("))(()))((()))"));
        System.out.println(longestValidParentheses("()(()"));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #Review
     * #Idea:()(() the issue index 2 as it break the length and we will never know until the end 
     * we will use stack and push -1 and use the index not the char 
     * when we have ) pop and if the stack empty mean it is not a valid and push the last index
     * if not empty mean it is a valid and calculate the length  
     * 
     * ))(()))((()))
     * )()())
     * ()(()
     */
    public static int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        //initial if start with a valid 
        st.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                st.push(i);
            else {
                st.pop();
                //not a valid 
                if (st.isEmpty())
                    st.push(i);
                else
                //valid and calculate the length
                ans = Math.max(ans, i - st.peek());
            }
        }
        return ans;
    }

    
}