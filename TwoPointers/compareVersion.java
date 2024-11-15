package TwoPointers;

import java.util.List;

public class compareVersion {
    /*
     * https://leetcode.com/problems/compare-version-numbers/description/
     * 165. Compare Version Numbers
     * Given two version strings, version1 and version2, compare them. A version
     * string consists of revisions separated by dots '.'. The value of the revision
     * is its integer conversion ignoring leading zeros.
     * To compare version strings, compare their revision values in left-to-right
     * order. If one of the version strings has fewer revisions, treat the missing
     * revision values as 0.
     * Return the following:
     * If version1 < version2, return -1.
     * If version1 > version2, return 1.
     * Otherwise, return 0.
     * Example 1:
     * Input: version1 = "1.2", version2 = "1.10"
     * Output: -1
     * Explanation:
     * version1's second revision is "2" and version2's second revision is "10": 2 <
     * 10, so version1 < version2.
     * Example 2:
     * Input: version1 = "1.01", version2 = "1.001"
     * Output: 0
     * Explanation:
     * Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
     * Example 3:
     * Input: version1 = "1.0", version2 = "1.0.0.0"
     * Output: 0
     * Explanation:
     * version1 has less revisions, which means every missing revision are treated
     * as "0".
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        // Test cases
        String version1 = "1.0.1";
        String version2 = "1.0";
        System.out
                .println("Comparing '" + version1 + "' with '" + version2 + "': " + compareVersion(version1, version2)); // Expected:
                                                                                                                         // 1

        version1 = "1.0.0";
        version2 = "1";
        System.out
                .println("Comparing '" + version1 + "' with '" + version2 + "': " + compareVersion(version1, version2)); // Expected:
                                                                                                                         // 0

        version1 = "1.01";
        version2 = "1.001";
        System.out
                .println("Comparing '" + version1 + "' with '" + version2 + "': " + compareVersion(version1, version2)); // Expected:
                                                                                                                         // 0

        version1 = "1.2";
        version2 = "1.10";
        System.out
                .println("Comparing '" + version1 + "' with '" + version2 + "': " + compareVersion(version1, version2)); // Expected:
                                                                                                                         // -1

        version1 = "2.0.1";
        version2 = "2.0.0";
        System.out
                .println("Comparing '" + version1 + "' with '" + version2 + "': " + compareVersion(version1, version2)); // Expected:
                                                                                                                         // 1

    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    // version1 = "1.0", version2 = "1.0.0.0"
    public static int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        // compare versions
        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        //The versions are equal
        return 0;
    }
}