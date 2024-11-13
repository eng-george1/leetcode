package SlidingWindow;

public class minWindow {
    /*
     * https://leetcode.com/problems/minimum-window-substring/description/
     * 76. Minimum Window Substring
     * Given two strings s and t of lengths m and n respectively, return the minimum
     * window
     * substring
     * of s such that every character in t (including duplicates) is included in the
     * window. If there is no such substring, return the empty string "".
     * The testcases will be generated such that the answer is unique.
     * Example 1:
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
     * from string t.
     * Example 2:
     * Input: s = "a", t = "a"
     * Output: "a"
     * Explanation: The entire string s is the minimum window.
     * Example 3:
     * Input: s = "a", t = "aa"
     * Output: ""
     * Explanation: Both 'a's from t must be included in the window.
     * Since the largest window of s only has one 'a', return empty string.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        // Test case 1
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Test case 1: " + minWindow(s1, t1)); // Expected output: "BANC"

        // Test case 2
        String s2 = "a";
        String t2 = "a";
        System.out.println("Test case 2: " + minWindow(s2, t2)); // Expected output: "a"

        // Test case 3
        String s3 = "a";
        String t3 = "aa";
        System.out.println("Test case 3: " + minWindow(s3, t3)); // Expected output: ""

        // Test case 4
        String s4 = "AA";
        String t4 = "AA";
        System.out.println("Test case 4: " + minWindow(s4, t4)); // Expected output: "AA"

        // Test case 5
        String s5 = "this is a test string";
        String t5 = "tist";
        System.out.println("Test case 5: " + minWindow(s5, t5)); // Expected output: "t stri"

        // Test case 6 (Edge case)
        String s6 = "";
        String t6 = "abc";
        System.out.println("Test case 6: " + minWindow(s6, t6)); // Expected output: ""

        // Test case 7 (Edge case)
        String s7 = "abc";
        String t7 = "";
        System.out.println("Test case 7: " + minWindow(s7, t7)); // Expected output: ""
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        String res = "";
        int[] letterCount = new int[128];
        int left = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;

        for (char c : t.toCharArray()) {
            ++letterCount[c];
        }
        for (int right = 0; right < s.length(); ++right) {
            if (--letterCount[s.charAt(right)] >= 0) {
                ++count;
            }

            while (count == t.length()) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                if (++letterCount[s.charAt(left)] > 0) {
                    --count;
                }
                ++left;
            }
        }
        return res;
    }
}