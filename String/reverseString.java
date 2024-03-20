//package ;
public class reverseString {
    /*
     * https://leetcode.com/problems/reverse-string/description/
     * Write a function that reverses a string. The input string is given as an
     * array of characters s.
     * 
     * You must do this by modifying the input array in-place with O(1) extra
     * memory.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     * Example 2:
     * 
     * Input: s = ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     * 
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n) SC: O(1)

     */
    public static char[] reverseString(char[] s) {

        int p = 0;
        while (p < s.length - p) {
            char temp = s[p];
            s[p] = s[s.length - p - 1];
            s[s.length - p-1] = temp;
            p++;
        }
        return s;
    }
}