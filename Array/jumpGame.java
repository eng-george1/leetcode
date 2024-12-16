package Array;

public class jumpGame {
    /*
     * https://leetcode.com/problems/jump-game/description/
     * 55. Jump Game
     * You are given an integer array nums. You are initially positioned at the
     * array's first index, and each element in the array represents your maximum
     * jump length at that position.
     * 
     * Return true if you can reach the last index, or false otherwise.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     * 
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum
     * jump length is 0, which makes it impossible to reach the last index.
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
        System.out.println(canJump(new int[] { 0, 1 }));// false
    }

    /*
     * #Notes
     * #Review
     * #Idea: calculate the max reach and check that with the current index if less
     * means i can't reach to this index
     * calculate the max reach by index+num
     * TC:O(n) SC: O(1)
     */
    public static boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reachable < i)// i can't reach this index
                return false;
            reachable = Math.max(reachable, i + nums[i]);// current index+jumps
        }
        return true;
    }

    // TC:O(n^2) SC: O(1)
    public static boolean canJump00(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                int index = i - 1;
                while (index >= 0) {
                    if (nums[index] > i - index)
                        break;
                    index--;
                }
                if (index < 0)
                    return false;
            }
        }
        return true;
    }
}