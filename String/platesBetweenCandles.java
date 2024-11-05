//package ;
public class platesBetweenCandles {
    /*
     * https://leetcode.com/problems/plates-between-candles/description
     * 2055. Plates Between Candles
     * There is a long table with a line of plates and candles arranged on top of
     * it. You are given a 0-indexed string s consisting of characters '*' and '|'
     * only, where a '*' represents a plate and a '|' represents a candle.
     * You are also given a 0-indexed 2D integer array queries where queries[i] =
     * [lefti, righti] denotes the substring s[lefti...righti] (inclusive). For each
     * query, you need to find the number of plates between candles that are in the
     * substring. A plate is considered between candles if there is at least one
     * candle to its left and at least one candle to its right in the substring.
     * For example, s = "||**||**|*", and a query [3, 8] denotes the substring
     * "*||**|". The number of plates between candles in this substring is 2, as
     * each of the two plates has at least one candle in the substring to its left
     * and right.
     * Return an integer array answer where answer[i] is the answer to the ith
     * query.
     * Example 1:
     * ex-1
     * Input: s = "**|**|***|", queries = [[2,5],[5,9]]
     * Output: [2,3]
     * Explanation:
     * - queries[0] has two plates between candles.
     * - queries[1] has three plates between candles.
     * Example 2:
     * ex-2
     * Input: s = "***|**|*****|**||**|*", queries =
     * [[1,17],[4,5],[14,17],[5,11],[15,16]]
     * Output: [9,0,0,0,0]
     * Explanation:
     * - queries[0] has nine plates between candles.
     * - The other queries have zero plates between candles.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};
        
        int[] result = platesBetweenCandles(s, queries);
        
        // Print results for each query
        for (int i = 0; i < result.length; i++) {
            System.out.println("Query " + i + ": " + result[i]);
        }
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        /*        "***|**|*****|**||**|*"
| Index             |  0 |  1 |  2 |  3 |  4 |  5 |  6 |  7 |  8 |  9 | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 | 19 | 20 |
|-------------------|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|
| Sequence          |  * |  * |  * |  | |  * |  * |  | |  * |  * |  * | *  |  * | |  |  * |  * | |  |  | |  * | *  |  | |  * |
| Nearest Right     |  3 |  3 |  3 |  3 |  6 |  6 |  6 | 12 | 12 | 12 | 12 | 12 | 12 | 15 | 15 | 15 | 16 | 19 | 19 | 19 |  - |
| Nearest Left      |  - |  - |  - |  3 |  3 |  3 |  6 |  6 |  6 |  6 |  6 |  6 | 12 | 12 | 12 | 15 | 16 | 16 | 16 | 19 | 19 |
| Candle Count      |  0 |  0 |  0 |  1 |  1 |  1 |  2 |  2 |  2 |  2 |  2 |  2 |  3 |  3 |  3 |  4 |  5 |  5 |  5 |  6 |  6 |

         * 
         * 
| Index             |  0 |  1 |  2 |  3 |  4 |  5 |  6 |  7 |  8 |  9 |
|-------------------|----|----|----|----|----|----|----|----|----|----|
| Sequence          |  * |  * |  | |  * |  * |  | |  * |  * |  * | |  |
| Nearest Right     |  2 |  2 |  2 |  5 |  5 |  5 |  9 |  9 |  9 |  9 |
| Nearest Left      |  - |  - |  2 |  2 |  2 |  5 |  5 |  5 |  5 |  9 |
| Candle Count      |  0 |  0 |  1 |  1 |  1 |  2 |  2 |  2 |  2 |  3 |

         */

        int n = s.length();

        int[] nearestRightCandle = new int[n];
        int[] nearestLeftCandle = new int[n];
        int[] candleCount = new int[n];
        int[] ans = new int[queries.length];

        int candle = -1;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '|') {
                candle = i;
            }
            nearestLeftCandle[i] = candle;
        }

        candle = -1;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '|') {
                candle = i;
            }
            nearestRightCandle[i] = candle;
        }

        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '|') {
                ++count;
            }
            candleCount[i] = count;
        }

        int idx = 0;
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];

            int leftCandle = nearestRightCandle[left];
            int rightCandle = nearestLeftCandle[right];

            int d = 0;
            if (leftCandle == -1 || rightCandle == -1) {
                ans[idx] = 0;
            } else {
                d = rightCandle - leftCandle;
                if (d > 1) {
                    ans[idx] = rightCandle - leftCandle + 1 - (candleCount[rightCandle] - candleCount[leftCandle] + 1);
                } else {
                    ans[idx] = 0;
                }
            }

            ++idx;
        }

        return ans;
    }
}