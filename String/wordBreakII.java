//package ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class wordBreakII {
    /*
     * https://leetcode.com/problems/word-break-ii/
     * 140. Word Break II
     * Given a string s and a dictionary of strings wordDict, add spaces in s to
     * construct a sentence where each word is a valid dictionary word. Return all
     * such possible sentences in any order.
     * Note that the same word in the dictionary may be reused multiple times in the
     * segmentation.
     * Example 1:
     * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
     * Output: ["cats and dog","cat sand dog"]
     * Example 2:
     * Input: s = "pineapplepenapple", wordDict =
     * ["apple","pen","applepen","pine","pineapple"]
     * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
     * Explanation: Note that you are allowed to reuse a dictionary word.
     * Example 3:
     * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * Output: []
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        String s = "catsanddog";
        List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");
        List<String> sentences = wordBreak(s, wordDict);

        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }

    /*
     * TC:O(2^n) SC: O(n)
     * #Notes
     * #LastReview Yes
     * #Review
     * #Idea:
     */
    //O(mX2^m) O(2^m) we can replace current as string builder
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // Convert wordDict to a Set for quick lookups
        List<String> result = new ArrayList<>();
        backtrack(s, wordSet, 0, new ArrayList<>(), result);
        return result;
    }
    private static void backtrack(String s, Set<String> wordSet, int start, List<String> current, List<String> result) {
        // Base case: if we reach the end of the string, add the current path to result
        if (start == s.length()) {
            result.add(String.join(" ", current));
            return;
        }
        // Explore each substring starting from the current index
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                // Choose: add the word to the current list
                current.add(word);
                // Recurse
                backtrack(s, wordSet, end, current, result);
                // Backtrack: remove the last word added
                current.remove(current.size() - 1);
            }
        }
    }
     
    public static List<String> wordBreak01(String s, List<String> wordDict) {
        // Convert wordDict list to a Set for quick lookup of words
        Set<String> words = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>(); // List to store all possible sentences
        backtrack01(s, words, ans, new StringBuilder(), 0); // Start backtracking from index 0
        return ans;
    }

    // Backtracking function to generate sentences
    private static void backtrack01(String s, Set<String> words, List<String> ans, StringBuilder sb, int start) {
        // Base case: if we have reached the end of the string, add the current sentence
        // to results
        if (start == s.length()) {
            ans.add(sb.toString().trim()); // Add trimmed sentence to results
            return;
        }

        // Explore each substring starting from 'start' to the end of the string
        for (int end = start; end < s.length(); end++) {
            // Extract the substring from 'start' to 'end'
            String word = s.substring(start, end + 1);

            // If the substring is a valid word
            if (words.contains(word)) {
                int len = sb.length(); // Remember current length of StringBuilder before appending

                // Append the word and a space to build the sentence
                sb.append(word).append(" ");

                // Recurse with the next starting index
                backtrack01(s, words, ans, sb, end + 1);

                // Backtrack by resetting the StringBuilder to its previous length
                sb.setLength(len);
            }
        }
    }

    public static List<String> wordBreak2(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // Convert wordDict to a Set for fast lookup
        Map<Integer, List<String>> dp = new HashMap<>(); // Memoization map to store intermediate results
        return wordBreakHelper2(s, 0, wordSet, dp);
    }

    private static List<String> wordBreakHelper2(String s, int start, Set<String> wordSet,
            Map<Integer, List<String>> dp) {
        // If we have already computed the result for this starting index, return it
        if (dp.containsKey(start)) {
            return dp.get(start);
        }

        List<String> result = new ArrayList<>();

        // Base case: If start reaches the end of the string, add an empty string as a
        // way to end a sentence
        if (start == s.length()) {
            result.add("");
            return result;
        }

        // Explore all possible substrings starting from 'start' and ending at each
        // position from start + 1 to s.length()
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            // If the current substring is in the dictionary
            if (wordSet.contains(word)) {
                // Get all possible sentences starting from the next index 'end'
                List<String> subSentences = wordBreakHelper2(s, end, wordSet, dp);

                // For each sub-sentence, add the current word at the beginning
                for (String subSentence : subSentences) {
                    if (subSentence.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + subSentence);
                    }
                }
            }
        }

        // Cache the result for the current starting index
        dp.put(start, result);
        return result;
    }

}