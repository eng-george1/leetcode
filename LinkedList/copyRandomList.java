package LinkedList;

import java.util.HashMap;

import org.w3c.dom.Node;

import a_Basics.LinkedList.ListNode;

public class copyRandomList {
    /*
     * https://leetcode.com/problems/copy-list-with-random-pointer/description/
     * 138. Copy List with Random Pointer
     * A linked list of length n is given such that each node contains an additional
     * random pointer, which could point to any node in the list, or null.
     * Construct a deep copy of the list. The deep copy should consist of exactly n
     * brand new nodes, where each new node has its value set to the value of its
     * corresponding original node. Both the next and random pointer of the new
     * nodes should point to new nodes in the copied list such that the pointers in
     * the original list and copied list represent the same list state. None of the
     * pointers in the new list should point to nodes in the original list.
     * For example, if there are two nodes X and Y in the original list, where
     * X.random --> Y, then for the corresponding two nodes x and y in the copied
     * list, x.random --> y.
     * Return the head of the copied linked list.
     * The linked list is represented in the input/output as a list of n nodes. Each
     * node is represented as a pair of [val, random_index] where:
     * val: an integer representing Node.val
     * random_index: the index of the node (range from 0 to n-1) that the random
     * pointer points to, or null if it does not point to any node.
     * Your code will only be given the head of the original linked list.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(
                ListNode.generateNode(new Integer[][] { { 7, null }, { 13, 0 }, { 11, 4 }, { 10, 2 }, { 1, 0 } })
                        .toString());
        System.out.println(copyRandomList1(
                ListNode.generateNode(new Integer[][] { { 7, null }, { 13, 0 }, { 11, 4 }, { 10, 2 }, { 1, 0 } }))
                .toString());
        System.out.println(copyRandomList1(ListNode.generateNode(new Integer[][] { { -1, 0 } })).toString());
    }

    /*
     * // Definition for a Node.
     * class Node {
     * int val;
     * Node next;
     * Node random;
     * 
     * 
     */
    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:Hashmap to map the old and new nodes and then fix next and random
     */
    public static ListNode copyRandomList(ListNode head) {
        if (head == null)
            return null;
        HashMap<ListNode, ListNode> map = new HashMap<>();
        // duplicate the nodes and put in the map
        ListNode current = head;
        while (current != null) {
            ListNode newNode = new ListNode(current.val);
            map.put(current, newNode);
            current = current.next;
        }

        // fix the random pointer and next
        current = head;
        while (current != null) {
            ListNode newNode = map.get(current);
            newNode.next = map.get(current.next);
            newNode.random = map.get(current.random);
        }
        return map.get(head);
    }

    public static ListNode copyRandomList1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oldNode = head;

        // Creating the new head node.
        ListNode newNode = new ListNode(oldNode.val);
        visited.put(oldNode, newNode);

        // Iterate on the linked list until all nodes are cloned.
        while (oldNode != null) {
            // Get the clones of the nodes referenced by random and next pointers.
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);

            // Move one step ahead in the linked list.
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visited.get(head);
    }

    static HashMap<ListNode, ListNode> visited = new HashMap<ListNode, ListNode>();

    public static ListNode getClonedNode(ListNode node) {
        // If the node exists then
        if (node != null) {
            // Check if the node is in the visited dictionary
            if (visited.containsKey(node)) {
                // If its in the visited dictionary then return the new node reference from the
                // dictionary
                return visited.get(node);
            } else {
                // Otherwise create a new node, add to the dictionary and return it
                visited.put(node, new ListNode(node.val));
                return visited.get(node);
            }
        }
        return null;
    }

    // duplicate each node with new node and make it next to the old one
    public static ListNode copyRandomList02(ListNode head) {
        if (head == null)
            return null;
        // duplicate the nodes
        ListNode current = head;
        while (current != null) {
            ListNode newNode = new ListNode(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // fix the random pointer
        current = head;
        while (current != null) {
            if (current.random != null)
                current.next.random = current.random.next;
            current = current.next.next;
        }

        // get the new list only and fix the original
        ListNode newHead = head.next;
        current = head;
        ListNode currentNew = newHead;
        while (current != null) {
            current.next = current.next.next;
            current = current.next;
            if (current != null)
                currentNew.next = current.next;
            currentNew = currentNew.next;
        }
        return newHead;
    }
}
