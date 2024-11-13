//package ;

import java.util.PriorityQueue;

import Array.nextPermutation;

public class reorganizeString {
    /*
     * https://leetcode.com/problems/reorganize-string/
     * 767. Reorganize String
     * Given a string s, rearrange the characters of s so that any two adjacent
     * characters are not the same.
     * Return any possible rearrangement of s or return "" if not possible.
     * Example 1:
     * Input: s = "aab"
     * Output: "aba"
     * Example 2:
     * Input: s = "aaab"
     * Output: ""
     * 
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
        System.out.println(reorganizeString2("aaaaabbbbccccddd"));
  
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static String reorganizeString(String s) {
       
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        // o(n)
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        // O(26)
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0)
                pq.offer(new int[] { i + 'a', freq[i] });// o(logn)
        }
        StringBuilder sb = new StringBuilder();
        int[] blocked = new int[] { 0, 0 };
        // o(26)
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            sb.append((char) temp[0]);
            temp[1]--;
            if (blocked[1] > 0) {
                pq.offer(blocked);
                blocked = new int[] { 0, 0 };
            }
            if (temp[1] > 0)
                blocked = temp;
        }
        if (blocked[1] > 0)
            return "";
        return sb.toString();

    }

    public static String reorganizeString2(String s) {
        var charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }
        int maxCount = 0, letter = 0;
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > maxCount) {
                maxCount = charCounts[i];
                letter = i;
            }
        }
        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }
        var ans = new char[s.length()];
        int index = 0;

        // Place the most frequent letter
        while (charCounts[letter] != 0) {
            ans[index] = (char) (letter + 'a');
            index += 2;
            charCounts[letter]--;
        }

        // Place rest of the letters in any order
        for (int i = 0; i < charCounts.length; i++) {
            while (charCounts[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index += 2;
                charCounts[i]--;
            }
        }

        return String.valueOf(ans);
    }

}