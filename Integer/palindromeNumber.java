package Integer;

public class palindromeNumber {
    /*
    */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(d) SC: O(1) d: len of n
     */
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String s = String.valueOf(x);
        int index = 0;
        while (index < s.length() / 2) {
            if (s.charAt(index) != s.charAt(s.length() - 1 - index))
                return false;
            index++;
        }
        return true;
    }
}