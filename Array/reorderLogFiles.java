package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class reorderLogFiles {
    /*
     * https://leetcode.com/problems/reorder-data-in-log-files/description/
     * 937. Reorder Data in Log Files
     * You are given an array of logs. Each log is a space-delimited string of
     * words, where the first word is the identifier.
     * There are two types of logs:
     * Letter-logs: All words (except the identifier) consist of lowercase English
     * letters.
     * Digit-logs: All words (except the identifier) consist of digits.
     * Reorder these logs so that:
     * The letter-logs come before all digit-logs.
     * The letter-logs are sorted lexicographically by their contents. If their
     * contents are the same, then sort them lexicographically by their identifiers.
     * The digit-logs maintain their relative ordering.
     * Return the final order of the logs.
     * Example 1:
     * Input: logs =
     * ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
     * Output:
     * ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
     * Explanation:
     * The letter-log contents are all different, so their ordering is "art can",
     * "art zero", "own kit dig".
     * The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
     * Example 2:
     * Input: logs =
     * ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
     * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * Let N be the number of logs in the list and
     * M be the maximum length of a single log.
     * TC:O(M⋅N⋅logN) SC: O(M⋅logN)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    // ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
    public static String[] reorderLogFiles(String[] logs) {

        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // split each log into two parts: <identifier, content>
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                // case 1). both logs are letter-logs
                if (!isDigit1 && !isDigit2) {
                    // first compare the content
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0)
                        return cmp;
                    // logs of same content, compare the identifiers
                    return split1[0].compareTo(split2[0]);
                }

                // case 2). one of logs is digit-log
                if (!isDigit1 && isDigit2)
                    // the letter-log comes before digit-logs
                    return -1;
                else if (isDigit1 && !isDigit2)
                    return 1;
                else
                    // case 3). both logs are digit-log
                    return 0;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }
}