package Integer;
public class factorialTrailingZeroes {
    /*
     * https://leetcode.com/problems/factorial-trailing-zeroes/
     * Given an integer n, return the number of trailing zeroes in n!.
     * 
     * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: n = 3
     * Output: 0
     * Explanation: 3! = 6, no trailing zero.
     * Example 2:
     * 
     * Input: n = 5
     * Output: 1
     * Explanation: 5! = 120, one trailing zero.
     * Example 3:
     * 
     * Input: n = 0
     * Output: 0
     * 
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(logn) SC: O(1)
     * #Notes calculate how many five in the numbers
     * #Review
     */
    public static int trailingZeroes(int n) {
        int zeroCount = 0;
        long currentMultiple = 5;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}
