//package ;

import java.util.HashMap;

import javax.print.DocFlavor.READER;
import javax.xml.transform.Result;

public class longestSubstrinWithoutRepeatingCharacters {
    /*
    */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkewp"));
        System.out.println(lengthOfLongestSubstring("abcda"));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes when get the index from map add +1 to start after , when find char make sure
     * the start index is max of the current and in the map abccadefg
     * second c will move the start index to the first c+1 and second a will not do anything
     * #Review
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int startI=0, result=0;

        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)))
            //which one is bigger the current or in the map
            startI=Math.max(startI,map.get(s.charAt(i))+1);
            map.put(s.charAt(i), i);
            // length +1
            result=Math.max(result,(i-startI+1));
        }
        return result;
    }
}