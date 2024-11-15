package LinkedList;

import java.util.PriorityQueue;

import a_Basics.LinkedList.ListNode;

public class mergeKLists {
    /*
     * https://leetcode.com/problems/merge-k-sorted-lists/description/
     * 23. Merge k Sorted Lists
     * You are given an array of k linked-lists lists, each linked-list is sorted in
     * ascending order.
     * Merge all the linked-lists into one sorted linked-list and return it.
     * Example 1:
     * Input: lists = [[1,4,5],[1,3,4],[2,6]]
     * Output: [1,1,2,3,4,4,5,6]
     * Explanation: The linked-lists are:
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * merging them into one sorted list:
     * 1->1->2->3->4->4->5->6
     * Example 2:
     * Input: lists = []
     * Output: []
     * Example 3:
     * Input: lists = [[]]
     * Output: []
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        // Test case
        int[] values = { 1, 2, 3, 4, 5 };
        ListNode n1 = ListNode.generateNode(values);
        int[] values1 = { 1, 2, 3, 4, 5 };
        ListNode n2 = ListNode.generateNode(values1);
        int[] values2 = { 1, 2 };
        ListNode n3 = ListNode.generateNode(values2);
        System.out.println(mergeKLists(new ListNode[] { n1, n2, n3 }).toString());
        System.out.println(
                mergeKLists(ListNode.generateNodeList(new int[][] { { 1, 4, 5 }, { 1, 3, 4 }, { 2, 6 } })).toString());

    }

    /*
     * TC:O(Nlogk) where k is the number of linked lists. SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea: use min heap to get the first node for each list and get the top in
     * the heap and put the next of this item
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode result = new ListNode(-1);
        // add the first node for each list
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                pq.add(lists[i]);
        }
        ListNode current = result;
        while (!pq.isEmpty()) {
            ListNode selectedNode = pq.poll();
            current.next = selectedNode;
            if (selectedNode.next != null)
                pq.add(selectedNode.next);
            current = current.next;
        }
        return result.next;
    }
}