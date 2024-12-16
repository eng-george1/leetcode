package Sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

import a_Basics.stack;

public class findKthLargest {
  /*
   * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
   * 215. Kth Largest Element in an Array
   * Given an integer array nums and an integer k, return the kth largest element
   * in the array.
   * 
   * Note that it is the kth largest element in the sorted order, not the kth
   * distinct element.
   * 
   * Can you solve it without sorting?
   * 
   * 
   * 
   * Example 1:
   * 
   * Input: nums = [3,2,1,5,6,4], k = 2
   * Output: 5
   * Example 2:
   * 
   * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
   * Output: 4
   * 
   * 
   * Constraints:
   * 
   * 1 <= k <= nums.length <= 105
   * -104 <= nums[i] <= 104
   */
  public static void main(String[] args) {
    System.out.println("Hello");
    int[] array = new int[] { 5, 2, 3, 1 };
    System.out.println(findKthLargest(array, 3));
    array = new int[] { 3, 2, 1, 5, 6, 4 };
    System.out.println(findKthLargest(array, 2));
    array = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
    System.out.println(findKthLargest(array, 4));

  }

  /*
   * TC:O(nlogn) SC: O(logn) using quick sort
   * #Notes
   * #LastReview
   * #Review
   * #Idea: Kth Largest Element in an Array = Mth smallest element in the array
   * where M=n-k+1
   * 1234567 k=5-->3
   * 1234567 M=7-5+1=3-->3
   */
  public static int findKthLargest1(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length - 1, nums.length - k);

  }

  private static int quickSelect(int[] nums, int low, int high, int k) {

    int pi = partition(nums, low, high);
    if (pi == k)
      return nums[pi];
    else if (pi > k)
      return quickSelect(nums, low, pi - 1, k);
    return quickSelect(nums, pi + 1, high, k);

  }

  private static int partition(int[] nums, int low, int high) {
    int pivot = nums[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (nums[j] < pivot) {
        i++;
        swap(nums, i, j);
      }
    }
    swap(nums, high, i + 1);
    return i + 1;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  /*
   * #Notes
   * #LastReview
   * #Review
   * #Idea: filling the heap with the first k elements and after that remove and add 
   * TC:O(nlogn) SC: O(k)
   */
  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // filling the heap with the first k elements
    for (int i = 0; i < k; i++) {
      minHeap.offer(nums[i]);
    }
    for (int i = k; i < nums.length; i++) {
      if (nums[i] > minHeap.peek()) {
        minHeap.poll();
        minHeap.offer(nums[i]);
      }
    }
    return minHeap.peek();
  }
}