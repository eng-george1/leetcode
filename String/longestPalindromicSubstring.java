//package ;
public class longestPalindromicSubstring {
    /*
     * https://leetcode.com/problems/longest-palindromic-substring/description/
     * Given a string s, return the longest
     * palindromic
     * 
     * substring
     * in s.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * Example 2:
     * 
     * Input: s = "cbbd"
     * Output: "bb"
     * 
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(longestPalindrome("abaabbaabbababc"));
        System.out.println(longestPalindrome00("abaabbaabbababc"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome(
                "vvgogaewginhopuxzwyryobjjpieyhwfopiowxmyylvcgsnhfcnogpqpukzmnpewavoutbloyrrhatimmxfqmcwgfebuoqbbgvubbkjfvxivjfijlpvtsnhagzfptahhyojwzamayoiegkenycnkxzkambimhdykdcxyyfjnvztzypmfczdhhnkmfuvgkhzbwmjznykkagqdrueohgcmeidjqsvfugcioeduohprjtfdmtzosnhoiganffarokxjifzzxhixdzycwfheqqegduzwtiacmdhqfmxhazcxsqyrvrihfqzjxvawdeandnwgjlquvzadruiqmcsgibglhicsvzqknztqpkiihdoisxipkourentfvrltieihiktgzswtgcmmlfrjifqinhrbplbsgswqlbjkyxjwoshsvxlhlpgzwbmxzwaemtowcxwourjwmmwjruowxcwotmeawzxmbwzgplhlxvshsowjxykjblqwsgsblpbrhniqfijrflmmcgtwszgtkihieitlrvftneruokpixsiodhiikpqtznkqzvscihlgbigscmqiurdazvuqljgwndnaedwavxjzqfhirvryqsxczahxmfqhdmcaitwzudgeqqehfwcyzdxihxzzfijxkoraffnagiohnsoztmdftjrphoudeoicgufvsqjdiemcghoeurdqgakkynzjmwbzhkgvufmknhhdzcfmpyztzvnjfyyxcdkydhmibmakzxkncynekgeioyamazwjoyhhatpfzgahnstvpljifjvixvfjkbbuvgbbqoubefgwcmqfxmmitahrryolbtuovawepnmzkupqpgoncfhnsgcvlyymxwoipofwhyeipjjboyrywzxupohnigweagogvv"));
    }

    /*
     * TC:O(n^2) SC: O(1)
     * #Notes substring (i,j+1), we can have two pointers and from  middle and from longest to smalles
     * #Review
     */
  static  int startI = 0;
   static int endI = 0;

   public static String longestPalindrome(String s) {
       int left = 0;
       int right = 0;
       for (int i = 0; i < s.length(); i++) {
           expandarroundCenter(s, i, i);
           expandarroundCenter(s, i, i + 1);

       }
       return s.substring(startI, endI + 1);
   }
   private static void expandarroundCenter(String s, int left, int right) {
       while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
           left--;
           right++;
       }
       if (endI - startI + 1 < right - left - 1) {
           startI = left + 1;
           endI = right - 1;
       }
   }
     /*
     * TC:O(n^2) SC: O(1)
     * #Notes good solution but not the best

     */
    public static String longestPalindrome01(String s) {
        if (s.isBlank() || s.isEmpty() || s.length() == 1)
            return s;
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String s1 = expand(s, i, i + 1);
            String s2 = expand(s, i - 1, i + 1);
            if (s1.length() > result.length())
                result = s1;
            if (s2.length() > result.length())
                result = s2;
        }
        return result;
    }

    private static String expand(String s, int left, int right) {
        String res = "";
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right))
                res = s.substring(left, right+1);
            else
                return res;
            left--;
            right++;
        }
        return res;
    }

    /*
     * TC:O(n^2) SC: O(n)
     * #Notes substring (i,j+1)
     */
    public static String longestPalindrome00(String s) {
        if (s.isBlank() || s.isEmpty() || s.length() == 1)
            return s;
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.substring(i, j + 1).equals(new StringBuilder(s.substring(i, j + 1)).reverse().toString())) {
                    if (result.length() < j - i + 1)
                        result = s.substring(i, j + 1);
                }

            }
        }

        return result;
    }
}