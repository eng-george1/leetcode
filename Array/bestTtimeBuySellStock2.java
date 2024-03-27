package Array;

public class bestTtimeBuySellStock2 {
    /*
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
     * 122. Best Time to Buy and Sell Stock II
     * 
     * You are given an integer array prices where prices[i] is the price of a given
     * stock on the ith day.
     * 
     * On each day, you may decide to buy and/or sell the stock. You can only hold
     * at most one share of the stock at any time. However, you can buy it then
     * immediately sell it on the same day.
     * 
     * Find and return the maximum profit you can achieve.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit =
     * 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 =
     * 3.
     * Total profit is 4 + 3 = 7.
     * Example 2:
     * 
     * Input: prices = [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit =
     * 5-1 = 4.
     * Total profit is 4.
     * Example 3:
     * 
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: There is no way to make a positive profit, so we never buy the
     * stock to achieve the maximum profit of 0.
     * 
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(maxProfit(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }

    /*
     * TC:O(n) SC: O(1)
     * #Notes
     * #Review
     */
    public static int maxProfit(int[] prices) {
        // track only profit
        // #Notes if you get up in number i mean the number after greater than before
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static int maxProfit01(int[] prices) {
        if (prices.length < 2)
            return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minPrice > 0) {
                maxProfit += prices[i] - minPrice;
                minPrice = prices[i];
            }
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

}