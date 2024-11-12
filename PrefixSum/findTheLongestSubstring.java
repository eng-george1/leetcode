package PrefixSum ;
public class findTheLongestSubstring {
    /*
     * https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in
     * -even-counts/description/
     * 1371. Find the Longest Substring Containing Vowels in Even Counts
     * Given the string s, return the size of the longest substring containing each
     * vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must
     * appear an even number of times.
     * Example 1:
     * Input: s = "eleetminicoworoep"
     * Output: 13
     * Explanation: The longest substring is "leetminicowor" which contains two each
     * of the vowels: e, i and o and zero of the vowels: a and u.
     * Example 2:
     * Input: s = "leetcodeisgreat"
     * Output: 5
     * Explanation: The longest substring is "leetc" which contains two e's.
     * Example 3:
     * Input: s = "bcbcbc"
     * Output: 6
     * Explanation: In this case, the given string "bcbcbc" is the longest because
     * all vowels: a, e, i, o and u appear zero times.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        String s = "eleetminicoworoep";
        int result = findTheLongestSubstring(s);
        System.out.println("The length of the longest substring with even counts of vowels is: " + result);

    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static int findTheLongestSubstring(String s) {
        int prefixXOR = 0;
        int[] characterMap = new int[26];
        characterMap['a' - 'a'] = 1;
        characterMap['e' - 'a'] = 2;
        characterMap['i' - 'a'] = 4;
        characterMap['o' - 'a'] = 8;
        characterMap['u' - 'a'] = 16;
        int[] mp = new int[32];// we have 5 chars 2^5=32 
        for (int i = 0; i < 32; i++)
            mp[i] = -1;
        int longestSubstring = 0;
        for (int i = 0; i < s.length(); i++) {
            prefixXOR ^= characterMap[s.charAt(i) - 'a'];
            if (mp[prefixXOR] == -1 && prefixXOR != 0)
                mp[prefixXOR] = i;
            longestSubstring = Math.max(longestSubstring, i - mp[prefixXOR]);
        }
        return longestSubstring;
    }

}