package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class partition {
    /*
     * https://leetcode.com/problems/palindrome-partitioning/description/
     * 131. Palindrome Partitioning
     * Given a string s, partition s such that every
     * substring
     * of the partition is a
     * palindrome
     * . Return all possible palindrome partitioning of s.
     * Example 1:
     * Input: s = "aab"
     * Output: [["a","a","b"],["aa","b"]]
     * Example 2:
     * Input: s = "a"
     * Output: [["a"]]
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        partition p=new partition();
        p.partition("aab");
    }

    /*
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:O(nX2^n) SC: O(n)
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        backTracking(0, result, new ArrayList<String>(), s);
        return result;
    }

    void backTracking(int start, List<List<String>> result, List<String> currentList, String s) {
        if (start >= s.length())
            result.add(new ArrayList<String>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1));
                backTracking(end + 1, result, currentList, s);
                // backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        }
        return true;
    }
}