//package ;
public class longestCommonPrefix {
    /*
    https://leetcode.com/problems/longest-common-prefix/
    Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 
    */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #Review
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
           return "";
       String prefix = strs[0];
       for (int i = 1; i < strs.length; i++) {
        //#Notes check if the prefix not exsit and should be index 0 we can't have "flow","cflow"
           while (strs[i].indexOf(prefix) != 0) {
            //remove last char and try again untill no char
               prefix = prefix.substring(0, prefix.length() - 1);
               if (prefix == "")
                   return "";
           }

       }
       return prefix;
   }
}