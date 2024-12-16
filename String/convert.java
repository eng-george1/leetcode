import java.util.*;

public class convert {
    /*
     * https://leetcode.com/problems/zigzag-conversion/description/
     * 6. Zigzag Conversion
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
     * of rows like this: (you may want to display this pattern in a fixed font for
     * better legibility)
     * P A H N
     * A P L S I I G
     * Y I R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * Write the code that will take a string and make this conversion given a
     * number of rows:
     * string convert(string s, int numRows);
     * Example 1:
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * P I N
     * A L S I G
     * Y A H R
     * P I
     * Example 3:
     * Input: s = "A", numRows = 1
     * Output: "A"
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
     * TC:O(n) SC: O(1)
     */
    public String convert(String s, int numRows) {
        // Handle edge cases: no zigzag needed
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int step = 2 * numRows - 2; // The "full cycle" step size
        // Build the result row by row
        for (int row = 0; row < numRows; row++) {
            for (int i = row; i < s.length(); i += step) {
                // Add the character in the current row
                result.append(s.charAt(i));

                // Handle diagonal characters (if applicable)
                int diag = i + step - 2 * row;
                if (row != 0 && row != numRows - 1 && diag < s.length()) {
                    result.append(s.charAt(diag));
                }
            }
        }
        return result.toString();
    }

    public String convert01(String s, int numRows) {
        // Step 1: Create a 2D array to store characters in a zigzag pattern
        Character[][] arr = new Character[s.length()][numRows];
        int count = 0; // Represents the current row index (position in zigzag)
        boolean up = true; // Direction flag: true -> moving down, false -> moving up

        // Step 2: Fill the 2D array following the zigzag pattern
        for (int i = 0; i < s.length(); i++) {
            // Place the current character of the string into the current row (count)
            arr[i][count] = s.charAt(i);

            // If we reach the bottom row, change direction to move up
            if (count == numRows - 1) {
                up = false;
            }
            // If we reach the top row, change direction to move down
            else if (count == 0) {
                up = true;
            }

            // If there's only one row, no zigzag movement is needed
            if (numRows == 1) {
                continue;
            }

            // Move to the next row based on the current direction
            if (up) {
                count++; // Move down
            } else {
                count--; // Move up
            }
        }

        // Step 3: Build the resulting string by reading the 2D array row by row
        String result = "";
        for (int i = 0; i < arr[0].length; i++) { // Iterate over rows (vertical dimension)
            for (int j = 0; j < arr.length; j++) { // Iterate over columns (horizontal dimension)
                if (arr[j][i] != null) { // Add only non-null characters to the result
                    result += arr[j][i];
                }
            }
        }
        // Step 4: Return the zigzag converted string
        return result;
    }

}