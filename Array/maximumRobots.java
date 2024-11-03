package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class maximumRobots {
    /*
     * https://leetcode.com/problems/maximum-number-of-robots-within-budget/
     * 2398. Maximum Number of Robots Within Budget
     * You have n robots. You are given two 0-indexed integer arrays, chargeTimes
     * and runningCosts, both of length n. The ith robot costs chargeTimes[i] units
     * to charge and costs runningCosts[i] units to run. You are also given an
     * integer budget.
     * The total cost of running k chosen robots is equal to max(chargeTimes) + k *
     * sum(runningCosts), where max(chargeTimes) is the largest charge cost among
     * the k robots and sum(runningCosts) is the sum of running costs among the k
     * robots.
     * Return the maximum number of consecutive robots you can run such that the
     * total cost does not exceed budget.
     * Example 1:
     * Input: chargeTimes = [3,6,1,3,4], runningCosts = [2,1,3,4,5], budget = 25
     * Output: 3
     * Explanation:
     * It is possible to run all individual and consecutive pairs of robots within
     * budget.
     * To obtain answer 3, consider the first 3 robots. The total cost will be
     * max(3,6,1) + 3 * sum(2,1,3) = 6 + 3 * 6 = 24 which is less than 25.
     * It can be shown that it is not possible to run more than 3 consecutive robots
     * within budget, so we return 3.
     * Example 2:
     * Input: chargeTimes = [11,12,19], runningCosts = [10,8,7], budget = 19
     * Output: 0
     * Explanation: No robot can be run that does not exceed the budget, so we
     * return 0.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(maximumRobots(new int[] { 3, 6, 1, 3, 4 }, new int[] { 2, 1, 3, 4, 5 }, 25));
        System.out.println(maximumRobots(new int[] { 11, 12, 19 }, new int[] { 10, 8, 7 }, 19));
        System.out.println(maximumRobots(new int[] { 11, 12, 74, 67, 37, 87, 42, 34, 18, 90, 36, 28, 34, 20 },
                new int[] { 18, 98, 2, 84, 7, 57, 54, 65, 59, 91, 7, 23, 94, 20 }, 937));//
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:Sliding Window + Mono Deque
     * Use a mono deque to find the maximum value in a sliding window.
     * 
     */

   public static int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) { // T.C: O(N) A.S: O()
        // PriorityQueue to keep track of the costs in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = runningCosts.length; // Total number of robots
        int res = Integer.MIN_VALUE; // Variable to store the maximum number of robots
        long cost = 0; // Variable to keep track of the total costs of the robots in the current window
        
        // Use two pointers i (right) and j (left) to maintain the sliding window
        for (int i = 0, j = 0; i < n; i++) {
            cost += runningCosts[i]; // Add the current robot's cost to the total cost
            pq.add(chargeTimes[i]); // Add the current robot's cost time to the priority queue
            
            // While the total cost exceeds the budget
            while (!pq.isEmpty() && (pq.peek() + pq.size() * cost > budget)) {
                // Remove the robot with the highest cost time from the priority queue
                pq.remove(chargeTimes[j]);
                cost -= runningCosts[j]; // Subtract the cost of the removed robot
                j++; // Move the left pointer to reduce the window size
            }
            
            // Update the result with the maximum size of the current valid window
            res = Math.max(res, pq.size());
        }
        
        return res; // Return the maximum number of robots that can be operated within the budget
    }

    // it solve 65/82 cases
    public static int maximumRobots2(int[] chargeTimes, int[] runningCosts, long budget) {
        int left = 0, right = 0, maxNo = 0;
        int currentMax = chargeTimes[0], currentSum = runningCosts[0];
        while (right < chargeTimes.length) {
            currentMax = getMax(chargeTimes, left, right);
            currentSum = getSum(runningCosts, left, right);
            int total = currentMax + (right + 1 - left) * currentSum;
            if (total == budget) {
                maxNo = Math.max(maxNo, right + 1 - left);
                left++;
                right++;

            }
            if (total > budget) {
                left++;
                currentSum -= runningCosts[left - 1];
                if (left > right) {
                    right = left;

                }
            } else {
                maxNo = Math.max(maxNo, right + 1 - left);
                right++;

            }

        }
        return maxNo;
    }

    private static int getMax(int[] chargeTimes, int start, int end) {
        int max = 0;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, chargeTimes[i]);
        }
        return max;
    }

    private static int getSum(int[] runningCosts, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += runningCosts[i];
        }
        return sum;
    }

    public static int maximumRobots1(int[] chargeTimes, int[] runningCosts, long budget) {

        return maximumRobots(chargeTimes, runningCosts, budget, new ArrayList<Integer>(), 0, 0);
    }

    public static int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget, List<Integer> currentTimes,
            int startIndex, int max) {
        if (currentTimes.size() > max && currentTimes.size() > 0) {
            // max(chargeTimes) + k * sum(runningCosts)
            int sumCosts = 0;
            int maxChargTimes = 0;

            for (int i = 0; i < currentTimes.size(); i++) {
                sumCosts += runningCosts[currentTimes.get(i)];
                maxChargTimes = Math.max(maxChargTimes, chargeTimes[currentTimes.get(i)]);
            }
            if (maxChargTimes + currentTimes.size() * sumCosts <= budget)
                max = Math.max(max, currentTimes.size());
        }
        if (currentTimes.size() == chargeTimes.length)
            return max;
        for (int index = startIndex; index < chargeTimes.length; index++) {
            currentTimes.add(index);
            max = Math.max(maximumRobots(chargeTimes, runningCosts, budget, currentTimes, startIndex + 1, max), max);
            currentTimes.remove(currentTimes.size() - 1);
        }
        return max;
    }
}