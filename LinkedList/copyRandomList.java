package LinkedList;

import java.util.HashMap;

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
        System.out.println(Node.generatNode(new Integer[][] { { 7, null }, { 13, 0 }, { 11, 4 }, { 10, 2 }, { 1, 0 } })
                .toString());
        System.out.println(copyRandomList1(
                Node.generatNode(new Integer[][] { { 7, null }, { 13, 0 }, { 11, 4 }, { 10, 2 }, { 1, 0 } }))
                .toString());
        System.out.println(copyRandomList1(Node.generatNode(new Integer[][] { { -1, 0 } })).toString());
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
     * #Idea:
     */
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public static Node generatNode(Integer[][] arrIntegers) {
            Node node = new Node(arrIntegers[0][0]);
            if (arrIntegers[0][1] != null)
                node.random = new Node(arrIntegers[0][1]);
            Node currNode = node;

            for (int i = 1; i < arrIntegers.length; i++) {
                currNode.next = new Node(arrIntegers[i][0]);
                currNode = currNode.next;
                if (arrIntegers[i][1] != null) {
                    currNode.random = new Node(arrIntegers[i][1]);
                }
            }
            return node;
        }

        public String toString() {
            Node currentNode = this;
            StringBuilder stringBuilder = new StringBuilder();
            while (currentNode != null) {
                if (currentNode.random != null)
                    stringBuilder.append("Node:" + currentNode.val + " Random:" + currentNode.random.val);
                else
                    stringBuilder.append("Node:" + currentNode.val + " Random: Null");
                stringBuilder.append(System.lineSeparator());
                currentNode = currentNode.next;
            }
            return stringBuilder.toString();
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;
        // duplicate the nodes
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
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
        Node newHead = head.next;
        current = head;
        Node currentNew = newHead;
        while (current != null) {
            current.next = current.next.next;
            current = current.next;
            if (current != null)
                currentNew.next = current.next;
            currentNew = currentNew.next;
        }
        return newHead;
    }

    static HashMap<Node, Node> visited = new HashMap<Node, Node>();

    public static Node getClonedNode(Node node) {
        // If the node exists then
        if (node != null) {
            // Check if the node is in the visited dictionary
            if (visited.containsKey(node)) {
                // If its in the visited dictionary then return the new node reference from the
                // dictionary
                return visited.get(node);
            } else {
                // Otherwise create a new node, add to the dictionary and return it
                visited.put(node, new Node(node.val));
                return visited.get(node);
            }
        }
        return null;
    }

    public static Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }

        Node oldNode = head;

        // Creating the new head node.
        Node newNode = new Node(oldNode.val);
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

    public static Node copyRandomList2(Node head) {
        if (head == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        // duplicate the nodes and put in the map
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            map.put(current, newNode);
            current = current.next;
        }

        // fix the random pointer and next
        current = head;
        while (current != null) {
            Node newNode = map.get(current);
            newNode.next = map.get(current.next);
            newNode.random = map.get(current.random);
        }
        return map.get(head);
    }

}
