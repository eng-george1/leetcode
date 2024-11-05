package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class pickIndex {
    /* https://leetcode.com/problems/random-pick-with-weight/description/
    528. Random Pick with Weight
    You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).
For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
Example 1:
Input
["Solution","pickIndex"]
[[[1]],[]]
Output
[null,0]
Explanation
Solution solution = new Solution([1]);
solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element in w.
Example 2:
Input
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output
[null,1,1,1,1,0]
Explanation
Solution solution = new Solution([1, 3]);
solution.pickIndex(); // return 1. It is returning the second element (index = 1) that has a probability of 3/4.
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 0. It is returning the first element (index = 0) that has a probability of 1/4.
Since this is a randomization problem, multiple answers are allowed.
All of the following outputs can be considered correct:
[null,1,1,1,1,0]
[null,1,1,1,1,1]
[null,1,1,1,0,0]
[null,1,1,1,0,1]
[null,1,0,1,0,0]
......
and so on.
     #PatchNo
    */
    public static void main(String[] args) {
        System.out.println("Hello");
          // Define weights
        int[] weights = {1, 3, 2, 4};  // Expect index 1 to be picked the most, followed by 3, then 2, and least likely 0.
        Solution solution = new Solution(weights);

        // Map to count occurrences of each index
        Map<Integer, Integer> countMap = new HashMap<>();

        // Run pickIndex several times to observe the distribution
        int numTrials = 10000;
        for (int i = 0; i < numTrials; i++) {
            int index = solution.pickIndex();
            countMap.put(index, countMap.getOrDefault(index, 0) + 1);
        }

        // Print results
        System.out.println("Index selection distribution after " + numTrials + " trials:");
        for (int i = 0; i < weights.length; i++) {
            System.out.printf("Index %d: %.2f%%\n", i, (countMap.getOrDefault(i, 0) / (double) numTrials) * 100);
        }
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    static  class  Solution {
        private int[] prefixSums;
        private int totalSum;
    
        public Solution(int[] w) {
            this.prefixSums = new int[w.length];
    
            int prefixSum = 0;
            for (int i = 0; i < w.length; ++i) {
                prefixSum += w[i];
                this.prefixSums[i] = prefixSum;
            }
            this.totalSum = prefixSum;
        }

        public int pickIndex() {
            double target = this.totalSum * Math.random();
    
            // run a binary search to find the target zone
            // return  Arrays.binarySearch(this.prefixSums,(int)Math.ceil(target) );
             // run a binary search to find the target zone
            int low = 0, high = this.prefixSums.length;
            while (low < high) {
                // better to avoid the overflow
                int mid = low + (high - low) / 2;
                if (target > this.prefixSums[mid])
                    low = mid + 1;
                else
                    high = mid;
            }
            return low;
        }
    
        public int pickIndex1() {
            double target = this.totalSum * Math.random();
            int i = 0;
            // run a linear search to find the target zone
            for (; i < this.prefixSums.length; ++i) {
                if (target < this.prefixSums[i])
                    return i;
            }
            // to have a return statement, though this should never happen.
            return i - 1;
      }
    }
}