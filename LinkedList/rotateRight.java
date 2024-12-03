package LinkedList;

import a_Basics.LinkedList.ListNode;

public class rotateRight {
    /*
     * https://leetcode.com/problems/rotate-list/description/
     * 61. Rotate List
     * Given the head of a linked list, rotate the list to the right by k places.
     * Example 1:
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [4,5,1,2,3]
     * Example 2:
     * Input: head = [0,1,2], k = 4
     * Output: [2,0,1]
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        ListNode node=ListNode.generateNode(new int[]{1,2,3,4,5});
        System.out.println(rotateRight(node,2).toString());
        ListNode node1=ListNode.generateNode(new int[]{0,1,2});
        System.out.println(rotateRight(node1,4).toString());
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea: connect the tail with the head get the length n  // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node and remove the link between new head and tail
     */
    public static ListNode rotateRight(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++) old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - (k % n) - 1; i++) new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }
}