//package ;
public class recursion {
    /*
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
    public static long factorialRecursive(int n) {
        if (n <= 1) { // base case: 0! = 1 and 1! = 1
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}