package Array;

import java.util.ArrayList;
import java.util.List;

public class sequentialDigits {
    /*
     * https://leetcode.com/problems/sequential-digits/description/
     * 1291. Sequential Digits
     * An integer has sequential digits if and only if each digit in the number is
     * one more than the previous digit.
     * 
     * Return a sorted list of all the integers in the range [low, high] inclusive
     * that have sequential digits.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: low = 100, high = 300
     * Output: [123,234]
     * Example 2:
     * 
     * Input: low = 1000, high = 13000
     * Output: [1234,2345,3456,4567,5678,6789,12345]
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(sequentialDigits(100, 300));
        System.out.println(sequentialDigits(1000, 13000));
        System.out.println(sequentialDigits(1234, 13000));
        System.out.println(sequentialDigits(234, 2314));
    }

    /*
     * TC:O(1) SC: O(1)
     * #Notes
     * #Review
     * #Idea:create a string "123456789" substring from it with for loop and len
     * starting from lowlen to highlen
     */
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        int lenlow = String.valueOf(low).length();
        int lenhigh = String.valueOf(high).length();
        String sq = "123456789";
        while (lenlow <= lenhigh) {
            for (int i = 0; i < 9 - lenlow + 1; i++) {
                int num = Integer.parseInt(sq.substring(i, i + lenlow));
                if (num >= low && num <= high)
                    result.add(num);
                else if (num > high) {
                    return result;
                }
            }
            lenlow++;
        }

        return result;
    }
}