package a_Basics;

import java.util.Arrays;

public class Knapsack {

   public static void main(String args[])
    {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int capacity = 50;
        int n = profit.length;
        System.out.println(knapsack( weight,profit,capacity, n));
    }
    //recursion O(2^n) Space: O(n)
    static int knapsack(int[] weights, int[] values, int capacity, int n) {
        if (n == 0 || capacity == 0) return 0;
        if (weights[n-1] > capacity) 
            return knapsack(weights, values, capacity, n-1);
        return Math.max(
            knapsack(weights, values, capacity, n-1),
            values[n-1] + knapsack(weights, values, capacity - weights[n-1], n-1)
        );
    }
    //Dynamic O(n*w)  space O(w)
   static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n+1][capacity+1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i-1] > w) dp[i][w] = dp[i-1][w];
                else dp[i][w] = Math.max(dp[i-1][w], values[i-1] + dp[i-1][w - weights[i-1]]);
            }
        }
        return dp[n][capacity];
    }


    //Fraction
    class Item {
    int value, weight;
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
    public double fractionalKnapsack(int capacity, Item[] items) {
        Arrays.sort(items, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));
        double maxValue = 0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                maxValue += item.value;
                capacity -= item.weight;
            } else {
                maxValue += (double)item.value * capacity / item.weight;
                break;
            }
        }
        return maxValue;
    }
/**
 * Comparison of Knapsack Variations:
 * 
 * Feature             | 0/1 Knapsack       | Fractional Knapsack   | Unbounded Knapsack
 * ------------------------------------------------------------------------------------
 * Item Selection      | Entirely or none  | Fractional allowed    | Multiple allowed
 * Approach            | DP               | Greedy               | DP
 * Time Complexity     | O(n×W)           | O(n log n)           | O(n×W)
 * Use Case            | Limited items    | Divisible items      | Unlimited items
 */

    public int unboundedKnapsack(int capacity, int[] weights, int[] values) {
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int w = weights[i]; w <= capacity; w++) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }
        return dp[capacity];
    }
}
