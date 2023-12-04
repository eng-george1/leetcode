package Integer;

public class pow {
    /*
     * https://leetcode.com/problems/powx-n/
     * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: x = 2.00000, n = 10
     * Output: 1024.00000
     * Example 2:
     * 
     * Input: x = 2.10000, n = 3
     * Output: 9.26100
     * Example 3:
     * 
     * Input: x = 2.00000, n = -2
     * Output: 0.25000
     * Explanation: 2-2 = 1/22 = 1/4 = 0.25
     * 
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(log2 n) SC: O(log2 n)
     * #Review
     * #Notes
     * 2^11=2^5*2^5*2
     * x^n=x^2/2*x^n/2*x--> last x if the n is odd
     * x^-n=1/(x^-n)
     */
    public double myPow(double x, int n) {
        /*
         * x=2.00000
         * n max min and when convert to + it will exceed the int storage
         * n=-2147483648
         */
        long n1 = (long) n;
        if (n1 == 0)
            return 1;
        if (n1 == 1)
            return x;
        if (n1 < 0) {
            // exceed storage if n max min
            n1 = n1 * -1;
            x = 1.0 / x;
        }

        double result = 1;
        while (n1 != 0) {
            if (n1 % 2 == 1) {
                result = result * x;
                n1 -= 1;
            }
            x = x * x;
            n1 = n1 / 2;
        }
        return result;
    }

    // using recursion
    public double myPow1(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0)
            return 1;
        double half = fastPow(x, n / 2);
        // if n is odd
        if (n % 2 == 0)
            return half * half;
        return half * half * x;
    }
}