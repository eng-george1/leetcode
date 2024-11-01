//package ;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak {
    /*
     * https://leetcode.com/problems/word-break/description/
     * https://www.youtube.com/watch?v=QgLKdluDo08&ab_channel=NeetCodeIO
     * 139. Word Break 
     * Given a string s and a dictionary of strings wordDict, return true if s can
     * be segmented into a space-separated sequence of one or more dictionary words.
     * Note that the same word in the dictionary may be reused multiple times in the
     * segmentation.
     * Example 1:
     * Input: s = "leetcode", wordDict = ["leet","code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     * Example 2:
     * Input: s = "applepenapple", wordDict = ["apple","pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as
     * "apple pen apple".
     * Note that you are allowed to reuse a dictionary word.
     * Example 3:
     * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * Output: false
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n^2) SC: O(n)
     * #Notes
     * #LastReview Yes
     * #Review
     * #Idea: using dynamic pro by caching the before checked you should review the backtracking
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // Convert wordDict to a set for faster lookups
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // An empty string can always be segmented
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // Check if s[0:j] can be segmented (dp[j] is true) and s[j:i] is in wordDict
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further, we found a valid segmentation
                }
            }
        }
        return dp[s.length()];
    }

    // Brute force solution using recursion backtracking O(2^n) space o(n)
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // Convert wordDict to a set for faster lookups
        return canBreak(s, wordSet, 0);
    }

    private boolean canBreak(String s, Set<String> wordSet, int start) {
        // Base case: if we reach the end of the string, return true
        if (start == s.length()) {
            return true;
        }

        // Try every possible end index for the current substring
        for (int end = start + 1; end <= s.length(); end++) {
            // Check if the substring s[start:end] is in the word set
            if (wordSet.contains(s.substring(start, end)) && canBreak(s, wordSet, end)) {
                return true;
            }
        }

        // If no valid segmentation found
        return false;
    }
}