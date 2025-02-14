package StacksQueues;

import java.util.Stack;

public class decodeString {
    /*
     * https://leetcode.com/problems/decode-string/
     * 394. Decode String
     * Given an encoded string, return its decoded string.
     * 
     * The encoding rule is: k[encoded_string], where the encoded_string inside the
     * square brackets is being repeated exactly k times. Note that k is guaranteed
     * to be a positive integer.
     * 
     * You may assume that the input string is always valid; there are no extra
     * white spaces, square brackets are well-formed, etc. Furthermore, you may
     * assume that the original data does not contain any digits and that digits are
     * only for those repeat numbers, k. For example, there will not be input like
     * 3a or 2[4].
     * 
     * The test cases are generated so that the length of the output will never
     * exceed 105.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "3[a]2[bc]"
     * Output: "aaabcbc"
     * Example 2:
     * 
     * Input: s = "3[a2[c]]"
     * Output: "accaccacc"
     * Example 3:
     * 
     * Input: s = "2[abc]3[cd]ef"
     * Output: "abcabccdcdcdef"
     * 
     * 
     * Constraints:
     * 
     * 1 <= s.length <= 30
     * s consists of lowercase English letters, digits, and square brackets '[]'.
     * s is guaranteed to be a valid input.
     * All the integers in s are in the range [1, 300].
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a3[b]cc]2[de]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("abc3[cd]xyz"));
        System.out.println(decodeString("100[leetcode]"));
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));

    }

    /*
     * TC:O(n) SC: O(n)
     * #LastReview
     * #Notes
     * #Review
     * #Idea: Nested and also start and end with string ab3[a2[c]abc] 
     * 3[a]2[bc]
     * 3[a2[c]abc]
     * https://www.youtube.com/watch?v=E9qHRcQXmDk&t=769s&ab_channel=NikhilLohia
     */
    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int k = 0;
    
        for (char c : s.toCharArray()) {
    
          if (Character.isDigit(c)) {
            //to get the full number not just digit(25) by digit 25[ab]
            k = (k * 10) + (c - '0');
            continue;
          }
    
          if (c == '[') {
            numStack.push(k);
            k = 0;
            stringStack.push(String.valueOf(c));
            continue;
          }
    
          if (c != ']') {
            // Char
            stringStack.push(String.valueOf(c));
            continue;
          }
          // ]
          StringBuilder temp = new StringBuilder();
          // pop all the char 
          while (!stringStack.peek().equals("["))
            temp.insert(0, stringStack.pop());
    
          // remove the "["
          stringStack.pop();
    
          // Get the new string
          StringBuilder replacement = new StringBuilder();
          int count = numStack.pop();
          for (int i = 0; i < count; i++)
            replacement.append(temp);
    
          //#Idea Add it to the stack
          stringStack.push(replacement.toString());
        }
    
        StringBuilder result = new StringBuilder();
        while (!stringStack.empty()) {
          result.insert(0, stringStack.pop());
        }
        return result.toString();
    }
    /*
     * Intuition :
1) If string does not have inner substring like this 3[a5[cd]] then it can be solved easily (simple iteration)
2) In some cases, we can have inner sub string as I mentioned above then it is best to solve with stack. Solve inner substring first.(Iterative approach)
3) Insert the character in stack until you find ']' char
4) If you find ']' char then pop the character until you find '[', This is how you can get the substring.
5) Remove the '[' character
6) Find the number k, number can be in single digit, two digits, .. so on.
7) Put back the substring k times in stack
8) Atlast take the result in one char array because stack format will not in string format.
9) return the result
     */
    //https://leetcode.com/problems/decode-string/solutions/1635285/java-single-stack-iterative-approach-detailed-explanation/
    // * #Idea: Nested and also start and end with string ab3[a2[c]abc] 
    // * 3[a]2[bc]
    // * 3[a2[c]abc]
    public static String decodeString1(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch != ']'){
                stack.push(ch);
            }else{
                //get the sub string
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '['){
                    sb.append(stack.pop());
                }
                //remove the '[' character
                stack.pop();
                //get the number
                int k = 0;
                int base = 1;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k = (stack.pop() - '0') * base + k;
                    base *= 10;
                }
                //put back the substring in stack k times
                while(k-- > 0){
                    for(int i=sb.length()-1; i>=0; i--){
                        stack.push(sb.charAt(i));
                    }
                }
            }
        }
        char[] result = new char[stack.size()];
        for(int i=stack.size()-1;i>=0;i--)
            result[i] = stack.pop();
        return new String(result);
    }
}