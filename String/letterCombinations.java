//package ;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class letterCombinations {
    /*
     * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
     * description/
     * 17. Letter Combinations of a Phone Number
     * Given a string containing digits from 2-9 inclusive, return all possible
     * letter combinations that the number could represent. Return the answer in any
     * order.
     * A mapping of digits to letters (just like on the telephone buttons) is given
     * below. Note that 1 does not map to any letters.
     * Example 1:
     * Input: digits = "23"
     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * Example 2:
     * Input: digits = ""
     * Output: []
     * Example 3:
     * Input: digits = "2"
     * Output: ["a","b","c"]
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:O(n*4^n) 4 max mapping chart, backtrack 4^n and extra n for convert
     * StringBuilder to string to digit SC: O(n)
     */
    private List<String> combinations = new ArrayList<>();
    private Map<Integer, String> letters = Map.of(2, "abc", 3, "def", 4, "ghi", 5, "jkl", 6, "mno", 7, "pqrs", 8, "tuv", 9, "wxyz");
    private String phoneDigits;
    public List<String> letterCombinations(String digits) {
        // If the input is empty, immediately return an empty answer array
        if (digits.length() == 0) {
            return combinations;
        }

        // Initiate backtracking with an empty path and starting index of 0
        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }

    private void backtrack(int index, StringBuilder path) {
        // If the path is the same length as digits, we have a complete combination
        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return; // Backtrack
        }

        // Get the letters that the current digit maps to, and loop through them
        int digit = phoneDigits.charAt(index) - '0';
        String possibleLetters = letters.get(digit);
        for (char letter : possibleLetters.toCharArray()) {
            // Add the letter to our current path
            path.append(letter);
            // Move on to the next digit
            backtrack(index + 1, path);
            // Backtrack by removing the letter before moving onto the next
            path.deleteCharAt(path.length() - 1);
        }
    }
}


