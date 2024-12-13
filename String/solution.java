
public class solution {
    /*
     * https://leetcode.com/problems/extra-characters-in-a-string/
     * 2707. Extra Characters in a String
     * You are given a 0-indexed string s and a dictionary of words dictionary. You
     * have to break s into one or more non-overlapping substrings such that each
     * substring is present in dictionary. There may be some extra characters in s
     * which are not present in any of the substrings.
     * Return the minimum number of extra characters left over if you break up s
     * optimally.
     * Example 1:
     * Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
     * Output: 1
     * Explanation: We can break s in two substrings: "leet" from index 0 to 3 and
     * "code" from index 5 to 8. There is only 1 unused character (at index 4), so
     * we return 1.
     * Example 2:
     * Input: s = "sayhelloworld", dictionary = ["hello","world"]
     * Output: 3
     * Explanation: We can break s in two substrings: "hello" from index 3 to 7 and
     * "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in
     * any substring and thus are considered as extra characters. Hence, we return
     * 3.
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
     * TC:O(n) SC: O(n)
     */
    public int minExtraChar(String s, String[] dictionary) {
        backTracking(s, dictionary, 0, s.length());
        return 0;
    }

    private void backTracking(String s, String[] dictionary, int start, int min) {
        if(start<=)
    }
}