
public class calculate {
    /*
     * https://leetcode.com/problems/basic-calculator-ii/
     * 227. Basic Calculator II
     * Given a string s which represents an expression, evaluate this expression and
     * return its value.
     * The integer division should truncate toward zero.
     * You may assume that the given expression is always valid. All intermediate
     * results will be in the range of [-231, 231 - 1].
     * Note: You are not allowed to use any built-in function which evaluates
     * strings as mathematical expressions, such as eval().
     * Example 1:
     * Input: s = "3+2*2"
     * Output: 7
     * Example 2:
     * Input: s = " 3/2 "
     * Output: 1
     * Example 3:
     * Input: s = " 3+5 / 2 "
     * Output: 5
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        calculate c=new calculate();
        c.calculate("3+22*2");
    }

    /*
     * TC:O(n) SC: O(1)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public int calculate(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int length = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');// 0+5
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }
}