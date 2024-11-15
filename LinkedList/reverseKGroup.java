package LinkedList;

import java.util.Stack;

import SlidingWindow.numberOfSubarrays;
import a_Basics.LinkedList;
import a_Basics.LinkedList.ListNode;

public class reverseKGroup {
    /*
     * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
     * 25. Reverse Nodes in k-Group
     * Given the head of a linked list, reverse the nodes of the list k at a time,
     * and return the modified list.
     * k is a positive integer and is less than or equal to the length of the linked
     * list. If the number of nodes is not a multiple of k then left-out nodes, in
     * the end, should remain as it is.
     * You may not alter the values in the list's nodes, only nodes themselves may
     * be changed.
     * Example 1:
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [2,1,4,3,5]
     * Example 2:
     * Input: head = [1,2,3,4,5], k = 3
     * Output: [3,2,1,4,5]
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        // Test case
        int[] values = { 1, 2, 3, 4, 5 };
        System.out.println(ListNode.generateNode(values)
                .toString());
        System.out.println(reverseKGroup(ListNode.generateNode(values), 2).toString());
        int[] values1 = { 1, 2, 3, 4, 5 };
        System.out.println(ListNode.generateNode(values1)
                .toString());
        System.out.println(reverseKGroup(ListNode.generateNode(values1), 3).toString());
        int[] values2 = { 1, 2 };
        System.out.println(ListNode.generateNode(values2)
                .toString());
        System.out.println(reverseKGroup(ListNode.generateNode(values2), 2).toString());
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea: use stack
     */
    // head = [1,2,3,4,5], k = 2 -->2,1,4,3,5 K=3 --> 3,2,1,4,5
    public static ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode result = new ListNode(-1);
        ListNode currentResult = result;
        ListNode current = head;
        while (current != null) {
            int count = 0;
            while (count < k && current != null) {
                stack.push(current);
                current = current.next;
                count++;
            }
            while (!stack.isEmpty()) {
                // if count<k mean the rest we need it in the same order so pop all the stack
                // and get last item and by default the last item connected with the other items
                if (count == k || stack.size() == 1) {
                    currentResult.next = stack.pop();
                    currentResult = currentResult.next;
                } else {
                    stack.pop();
                }
                // solve cycle issue for {1,2} k=2
                if (count == k) {
                    currentResult.next = null;
                }
            }
        }
        return result.next;
    }

    public static ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || k <= 1)
            return head;

        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(-1);
        ListNode currentResult = dummy;
        ListNode current = head;

        while (current != null) {
            int count = 0;
            // Push nodes into the stack until we reach k nodes or the end of the list
            while (count < k && current != null) {
                stack.push(current);
                current = current.next;
                count++;
            }

            // If we have a full group, pop from the stack to reverse the nodes
            if (count == k) {
                while (!stack.isEmpty()) {
                    currentResult.next = stack.pop();
                    currentResult = currentResult.next;
                }
                currentResult.next = null; // Prevent cycle
            } else {
                // For the last group with less than k nodes, attach them as is
                ListNode temp = null;
                while (!stack.isEmpty()) {
                    ListNode node = stack.pop();
                    node.next = temp;
                    temp = node;
                }
                currentResult.next = temp;
            }
        }

        return dummy.next;
    }

}