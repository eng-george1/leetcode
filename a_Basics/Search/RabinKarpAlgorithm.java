package a_Basics.Search;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgorithm {
    // d is the number of characters in the input alphabet (ASCII: 256)
    static final int d = 256;

    // Function to search for all occurrences of the pattern in the text
    public static List<Integer> search(String pattern, String text, int q) {
        int m = pattern.length(); // Length of the pattern
        int n = text.length();    // Length of the text
        int pHash = 0;            // Hash value for the pattern
        int tHash = 0;            // Hash value for the current window of text
        int h = 1;                // Value of d^(m-1)
        List<Integer> result = new ArrayList<>();

        // Calculate h = d^(m-1) % q
        for (int i = 0; i < m - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of the pattern and first window of text
        for (int i = 0; i < m; i++) {
            pHash = (d * pHash + pattern.charAt(i)) % q;
            tHash = (d * tHash + text.charAt(i)) % q;
        }

        // Slide the pattern over the text
        for (int i = 0; i <= n - m; i++) {
            // If the hash values match, check for a character-by-character match
            if (pHash == tHash) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    result.add(i); // Pattern found at index i
                }
            }

            // Calculate hash value for the next window of text
            if (i < n - m) {
                tHash = (d * (tHash - text.charAt(i) * h) + text.charAt(i + m)) % q;

                // We might get negative hash values, convert them to positive
                if (tHash < 0)
                    tHash += q;
            }
        }

        return result; // Return list of matching indices
    }

    public static void main(String[] args) {
        String text = "ababcabcababc";
        String pattern = "ababc";
        int q = 101; // A prime number

        List<Integer> occurrences = search(pattern, text, q);
        System.out.println("Pattern found at indices: " + occurrences);
    }
}

