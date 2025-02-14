package Integer;

public class countGoodNumbers {
    /*
     * https://leetcode.com/problems/count-good-numbers/description/
     * https://www.youtube.com/watch?v=CctVpEGgNf0&ab_channel=Fraz
     * 1922. Count Good Numbers
     * A digit string is good if the digits (0-indexed) at even indices are even and
     * the digits at odd indices are prime (2, 3, 5, or 7).
     * For example, "2582" is good because the digits (2 and 8) at even positions
     * are even and the digits (5 and 2) at odd positions are prime. However, "3245"
     * is not good because 3 is at an even index but is not even.
     * Given an integer n, return the total number of good digit strings of length
     * n. Since the answer may be large, return it modulo 109 + 7.
     * A digit string is a string consisting of digits 0 through 9 that may contain
     * leading zeros.
     * Example 1:
     * Input: n = 1
     * Output: 5
     * Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
     * Example 2:
     * Input: n = 4
     * Output: 400
     * Example 3:
     * Input: n = 50
     * Output: 564908303
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        long n = 4; // Example input
        System.out.println(countGoodNumbers(n)); // Output the result
    }

    /*
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * Even and Odd Positions:
     * ° For even indices, there are 5 choices (0, 2, 4, 6, 8).
     * ° For odd indices, there are 4 choices (2, 3, 5, 7).
     * Total Good Numbers:
     * ° If n is even, the total number of good numbers is 5^(n/2) * 4^(n/2) =
     * 20^(n/2)
     * ° If n is odd, the total number of good numbers is 5 * 20^((n-1)/2).
     * Modular Arithmetic:
     * ° Since the result can be very large, we compute everything modulo 10^9 + 7.
     * TC:O(logn) SC: O(logn)
     */
    private static final int MOD = 1_000_000_007;
    public static int countGoodNumbers(long n) {
        // Calculate the number of even and odd positions
        long evenPositions = (n + 1) / 2; // Number of even indices (0-based)
        long oddPositions = n / 2; // Number of odd indices
        // Calculate the total number of good numbers
        long evenChoices = pow(5, evenPositions); // 5 choices for each even position
        long oddChoices = pow(4, oddPositions); // 4 choices for each odd position
        // Multiply the two results and take modulo
        return (int) ((evenChoices * oddChoices) % MOD);
    }
    // Helper method to compute power with modulo
    private static long pow(long base, long exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent /= 2;
        }
        return result;
    }
}