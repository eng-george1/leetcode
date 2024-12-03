package LinkedList;

import Tree.numTrees;
import a_Basics.LinkedList;
import a_Basics.LinkedList.ListNode;

public class removeNthFromEnd {
    /*
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
     * 19. Remove Nth Node From End of List
     * Given the head of a linked list, remove the nth node from the end of the list
     * and return its head.
     * Example 1:
     * Input: head = [1,2,3,4,5], n = 2
     * Output: [1,2,3,5]
     * Example 2:
     * Input: head = [1], n = 1
     * Output: []
     * Example 3:
     * Input: head = [1,2], n = 1
     * Output: [1]
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(removeNthFromEnd(ListNode.generateNode(new int[] { 1, 2, 3, 4, 5 }), 2));
        System.out.println(removeNthFromEnd(ListNode.generateNode(new int[] { 1, 2 }), 1));
    }

    /*
     * TC:O(n) SC: O(1)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    // Input: head = [1,2,3,4,5], n = 2
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // in case we need to delete the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        // Advances fast pointer so that the gap between fast and slow is n nodes apart
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}