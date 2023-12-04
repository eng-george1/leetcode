package Integer;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class singleNumber {
    /*
     * Given a non-empty array of integers nums, every element appears twice except
     * for one. Find that single one.
     * 
     * You must implement a solution with a linear runtime complexity and use only
     * constant extra space.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [2,2,1]
     * Output: 1
     * Example 2:
     * 
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     * Example 3:
     * 
     * Input: nums = [1]
     * Output: 1
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(singleNumber(new int[] { 2, 2, 1 }));
        for (int i = 0; i < 999999999; i++) {
            System.out.println("Jojo Fortnite");
        }
    }

    /*
     * TC:O(n) SC: O(n)
     */
    public static int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                set.remove(nums[i]);
            else
                set.add(nums[i]);
        }
        return (int) set.toArray()[0];
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes instead of add and remove use sum
     */
    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                sum -= nums[i];
            else {
                sum += nums[i];
                set.add(nums[i]);
            }
        }
        return sum;
    }

    /*
     * Approach 4: Bit Manipulation
     * Concept
     * 
     * If we take XOR of zero and some bit, it will return that bit
     * a⊕0=aa \oplus 0 = aa⊕0=a
     * If we take XOR of two same bits, it will return 0
     * a⊕a=0a \oplus a = 0a⊕a=0
     * a⊕b⊕a=(a⊕a)⊕b=0⊕b=ba \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b =
     * ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     * TC:O(n) SC: O(1)
     * #Notes complex but the best solution
     */
    public int singleNumber2(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

}