//package ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class repeatedDnaSequences {
    /*
     * https://leetcode.com/problems/repeated-dna-sequences/
     * 
     * The DNA sequence is composed of a series of nucleotides abbreviated as 'A',
     * 'C', 'G', and 'T'.
     * 
     * For example, "ACGAATTCCG" is a DNA sequence.
     * When studying DNA, it is useful to identify repeated sequences within the
     * DNA.
     * 
     * Given a string s that represents a DNA sequence, return all the
     * 10-letter-long sequences (substrings) that occur more than once in a DNA
     * molecule. You may return the answer in any order.
     * 
     * #Notes 10 letter long
     * 
     * Example 1:
     * 
     * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * Output: ["AAAAACCCCC","CCCCCAAAAA"]
     * Example 2:
     * 
     * Input: s = "AAAAAAAAAAAAA"
     * Output: ["AAAAAAAAAA"]
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        String  s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    /*
     * TC:O(n) SC: O(n)  
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int p = 0;
        int lg = 10;
        Set<String> set = new HashSet<>();
        while (p <= s.length() - lg) {
            if (set.contains(s.substring(p, p + lg))) {
                if (!result.contains(s.substring(p, p + lg )))
                    result.add(s.substring(p, p + lg));
            }
            set.add(s.substring(p, p+lg));
            p++;
        }
        return result;
    }
}