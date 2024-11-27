package LinkedList;

import java.util.List;

import Array.printPermutations;
import Tree.numTrees;
import a_Basics.LinkedList.ListNode;

public class isPalindrome {
    /*
     * https://leetcode.com/problems/palindrome-linked-list/description/
     * 234. Palindrome Linked List
     * Given the head of a singly linked list, return true if it is a
     * palindrome
     * or false otherwise.
     * Example 1:
     * Input: head = [1,2,2,1]
     * Output: true
     * Example 2:
     * Input: head = [1,2]
     * Output: false
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    private ListNode frontPointer;

    // Recursive O(n) O(n)
    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next))
                return false;
            if (currentNode.val != frontPointer.val)
                return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    // Reverse Second Half In-place
    /*
     * Find the end of the first half.
     * Reverse the second half.
     * Determine whether or not there is a palindrome.
     * Restore the list.
     * Return the result.
     * O(n) O(1)
     */
    public boolean isPalindrome1(ListNode head) {

        if (head == null)
            return true;

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val)
                result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}