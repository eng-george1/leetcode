package Array;

import java.util.HashMap;
import java.util.Map;

public class getLargestOutlier {
    /*
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        int[] nums = { 1, 2, 3, 100, 5, 6 }; // Example input
        double result = findLargestOutlier(nums);
        System.out.println("Largest Outlier: " + result);
    }

    /*
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:O(n) SC: O(n)
     */
    public static int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int total = 0, res = Integer.MIN_VALUE;
        for (int num : nums) {
            total += num;
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            int outlier = total - num - num;
            if (count.getOrDefault(outlier, 0) > (outlier == num ? 1 : 0)) {
                res = Math.max(res, outlier);
            }
        }
        return res;
    }
}