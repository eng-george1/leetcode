package a_Basics.Search;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {

    // Function to calculate the LPS (Longest Prefix Suffix) array
    public static int[] calcPrefixLen(String pattern) {
        int patternLen = pattern.length();         // Length of the pattern
        int[] ar = new int[patternLen + 1];        // LPS array (1-based index)
        ar[0] = -1;                                // Sentinel value (can be ignored)
        ar[1] = 0;                                 // First character has no prefix-suffix match

        int prefixLen = 0;                         // Length of the current longest prefix-suffix
        int i = 1;                                 // Pointer to traverse the pattern

        while (i < patternLen) {
            if (pattern.charAt(prefixLen) == pattern.charAt(i)) {
                prefixLen++;                       // Increment the prefix length
                i++;                               // Move to the next character
                ar[i] = prefixLen;                 // Store the prefix length in the LPS array
            } else if (prefixLen > 0) {
                prefixLen = ar[prefixLen];         // Use the LPS value to find the next possible prefix length
            } else {
                i++;                               // Move to the next character
                ar[i] = 0;                         // No prefix-suffix match, set to 0
            }
        }

        return ar;                                 // Return the LPS array
    }

    // Function to search for all occurrences of the pattern in the text
    public static List<Integer> search(String text, String pattern) {
        int t = 0;                     // The position of the current character in text
        int p = 0;                     // The position of the current character in pattern
        int tLen = text.length();      // Length of the text
        int pLen = pattern.length();   // Length of the pattern

        List<Integer> matches = new ArrayList<>(); // List to store indices of matches
        int[] prefixLen = calcPrefixLen(pattern);  // Calculate LPS array for the pattern

        while (t < tLen) {
            if (pattern.charAt(p) == text.charAt(t)) {
                p++; // Move pattern pointer
                t++; // Move text pointer
                if (p == pLen) {
                    // Occurrence found, store the start index
                    matches.add(t - p);
                    p = prefixLen[p]; // Reset p using the LPS array
                }
            } else {
                p = prefixLen[p]; // Move to the next possible position in pattern
                if (p < 0) { // If p is less than 0, reset and move forward in text
                    t++;
                    p++;
                }
            }
        }

        return matches; // Return all matching indices
    }

    public static void main(String[] args) {
        String text = "ababcabcababc";
        String pattern = "ababc";
        List<Integer> occurrences = search(text, pattern);

        // Print the occurrences
        System.out.println("Pattern found at indices: " + occurrences);
    }
}

