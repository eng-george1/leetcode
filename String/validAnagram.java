//package ;
public class validAnagram {
    /*
    https://leetcode.com/problems/valid-anagram/
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false

    */
    public static void main(String[] args) {
        System.out.println("Hello");
String s = "anagram", t = "nagaram";
System.out.println(isAnagram(s,t));
    }

    /*
     * TC:O(n) SC: O(1)
     * #Notes Or we could first increment the counter for sss, then decrement the counter for ttt. If at any point the counter drops below zero, we know that ttt contains an extra letter not in sss and return false immediately.
     * #Review
     */
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        return false;
        int[] chars=new  int[26];
        // #Notes no need for initalization
        // for(int i=0;i<chars.length;i++){
        //     chars[i]=0;
        // }
        for(int i=0;i<s.length();i++){
            chars[s.charAt(i)-'a']++;
            chars[t.charAt(i)-'a']--;
        }
        for(int i=0;i<chars.length;i++){
            if(chars[i]>0)
            return false;
        }

        return true;
    }
}