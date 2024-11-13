//package ;
public class myAtoi {
    /* https://leetcode.com/problems/string-to-integer-atoi/
    8. String to Integer (atoi)
   Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 The algorithm for myAtoi(string s) is as follows: Whitespace: Ignore any leading whitespace (" ").
 Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
 Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 Return the integer as the final result.
 Example 1:
 Input: s = "42"
 Output: 42
 Explanation:
 The underlined characters are what is read in and the caret is the current reader position.
 Step 1: "42" (no characters read because there is no leading whitespace) ^
 Step 2: "42" (no characters read because there is neither a '-' nor '+') ^
 Step 3: "42" ("42" is read in) ^
 Example 2:
 Input: s = " -042"
 Output: -42
 Explanation:
 Step 1: "   -042" (leading whitespace is read and ignored) ^
 Step 2: "   -042" ('-' is read, so the result should be negative) ^
 Step 3: "   -042" ("042" is read in, leading zeros ignored in the result) ^
 Example 3:
 Input: s = "1337c0d3"
 Output: 1337
 Explanation:
 Step 1: "1337c0d3" (no characters read because there is no leading whitespace) ^
 Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+') ^
 Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit) ^
 Example 4:
 Input: s = "0-1"
 Output: 0
 Explanation:
 Step 1: "0-1" (no characters read because there is no leading whitespace) ^
 Step 2: "0-1" (no characters read because there is neither a '-' nor '+') ^
 Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit) ^
 Example 5:
 Input: s = "words and 987"
 Output: 0
 Explanation:
 Reading stops at the first non-digit character 'w'.

 
     #PatchNo
    */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public int myAtoi(String input) {
        int sign = 1;
        int result = 0;
        int index = 0;
        int n = input.length();

        // Discard all spaces from the beginning of the input string.
        while (index < n && input.charAt(index) == ' ') {
            index++;
        }

        // sign = +1, if it's positive number, otherwise sign = -1.
        if (index < n && input.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        // Traverse next digits of input and stop if it is not a digit
        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';

            // Check overflow and underflow conditions.
            if (
                (result > Integer.MAX_VALUE / 10) ||
                (result == Integer.MAX_VALUE / 10 &&
                    digit > Integer.MAX_VALUE % 10)
            ) {
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Append current digit to the result.
            result = 10 * result + digit;
            index++;
        }

        // We have formed a valid number without any overflow/underflow.
        // Return it after multiplying it with its sign.
        return sign * result;
    }
}