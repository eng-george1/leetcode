

public class repeatedStringMatch {
    /*
     * https://leetcode.com/problems/repeated-string-match/description/
     * 686. Repeated String Match
     * Given two strings a and b, return the minimum number of times you should
     * repeat string a so that string b is a substring of it. If it is impossible
     * for b​​​​​​ to be a substring of a after repeating it, return -1.
     * Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and
     * repeated 2 times is "abcabc".
     * Example 1:
     * Input: a = "abcd", b = "cdabcdab"
     * Output: 3
     * Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b
     * is a substring of it.
     * Example 2:
     * Input: a = "a", b = "aa"
     * Output: 2
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); q++)
            S.append(A);
        if (S.indexOf(B) >= 0)
            return q;
        if (S.append(A).indexOf(B) >= 0)
            return q + 1;
        return -1;
    }

    public int repeatedStringMatch01(String a, String b) {
        boolean[] mapAlpha = new boolean[26];
        int lenA = a.length();
        int lenB = b.length();
        int minRip = (int) Math.ceil((double) lenB / lenA); // Minimum repetitions needed
        // get the existed in the a
        for (int i = 0; i < lenA; i++) {
            mapAlpha[a.charAt(i) - 'a'] = true;
        }
        // check if b contains the same letters
        for (int i = 0; i < lenB; i++) {
            if (mapAlpha[b.charAt(i) - 'a'] == false)
                return -1;
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < minRip; i++) {
            s.append(a);
        }
        if (s.indexOf(b) >= 0) {
            return minRip;
        }
        s.append(a);
        minRip++;
        if (s.indexOf(b) >= 0) {
            return minRip;
        }
        return -1;
    }
}