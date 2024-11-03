//package ;
public class numberOfWays {
    /*
     * https://leetcode.com/problems/number-of-ways-to-select-buildings/description/
     * 2222. Number of Ways to Select Buildings
     * You are given a 0-indexed binary string s which represents the types of
     * buildings along a street where:
     * s[i] = '0' denotes that the ith building is an office and
     * s[i] = '1' denotes that the ith building is a restaurant.
     * As a city official, you would like to select 3 buildings for random
     * inspection. However, to ensure variety, no two consecutive buildings out of
     * the selected buildings can be of the same type.
     * For example, given s = "001101", we cannot select the 1st, 3rd, and 5th
     * buildings as that would form "011" which is not allowed due to having two
     * consecutive buildings of the same type.
     * Return the number of valid ways to select 3 buildings.
     * Example 1:
     * Input: s = "001101"
     * Output: 6
     * Explanation:
     * The following sets of indices selected are valid:
     * - [0,2,4] from "001101" forms "010"
     * - [0,3,4] from "001101" forms "010"
     * - [1,2,4] from "001101" forms "010"
     * - [1,3,4] from "001101" forms "010"
     * - [2,4,5] from "001101" forms "101"
     * - [3,4,5] from "001101" forms "101"
     * No other selection is valid. Thus, there are 6 total ways.
     * Example 2:
     * Input: s = "11100"
     * Output: 0
     * Explanation: It can be shown that there are no valid selections.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        String buildings = "001101"; // Sample input
        System.out.println("Number of ways to select buildings: " + numberOfWays(buildings));
        System.out.println("Number of ways to select buildings: " + numberOfWays1(buildings));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review Yes
     * #Idea:
     */
    public static long numberOfWays(String s) {
        int n = s.length();

        // Variables to count the occurrences of '0' and '1' up to the current index
        long count0 = 0, count1 = 0;
        // Variables to count '10' and '01' sequences up to the current index
        long count10 = 0, count01 = 0;
        // Final count of "101" and "010" patterns
        long totalWays = 0;

        for (int i = 0; i < n; i++) {
            char building = s.charAt(i);

            if (building == '0') {
                // When current building is '0', add count of '10' sequences to total ways,
                // as each '10' can form a "101" by adding this '0' at the end
                totalWays += count10;
                // Increase the count of '01' sequences by the number of '1's seen so far
                count01 += count1;
                // Increment the count of '0's
                count0++;
            } else if (building == '1') {
                // When current building is '1', add count of '01' sequences to total ways,
                // as each '01' can form a "010" by adding this '1' at the end
                totalWays += count01;
                // Increase the count of '10' sequences by the number of '0's seen so far
                count10 += count0;
                // Increment the count of '1's
                count1++;
            }
        }

        return totalWays;
    }

    public static long numberOfWays1(String s) {
        long[] dp0 = new long[3];
        long[] dp1 = new long[3];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                dp0[0]++;
                dp0[1] += dp1[0];
                dp0[2] += dp1[1];
            } else {
                dp1[0]++;
                dp1[1] += dp0[0];
                dp1[2] += dp0[1];
            }
            // System.out.println(Arrays.toString(dp0));
            // System.out.println(Arrays.toString(dp1));
        }

        return dp0[2] + dp1[2];
    }
}