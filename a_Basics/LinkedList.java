package a_Basics;

public class LinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode random;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public static ListNode generateNode(Integer[][] arrIntegers) {
            ListNode node = new ListNode(arrIntegers[0][0]);
            if (arrIntegers[0][1] != null)
                node.random = new ListNode(arrIntegers[0][1]);
            ListNode currNode = node;

            for (int i = 1; i < arrIntegers.length; i++) {
                currNode.next = new ListNode(arrIntegers[i][0]);
                currNode = currNode.next;
                if (arrIntegers[i][1] != null) {
                    currNode.random = new ListNode(arrIntegers[i][1]);
                }
            }
            return node;
        }

        public static ListNode generateNode(int[] arrIntegers) {
            ListNode node = new ListNode(arrIntegers[0]);
            // if (arrIntegers[0] != null)
            node.random = new ListNode(arrIntegers[0]);
            ListNode currNode = node;

            for (int i = 1; i < arrIntegers.length; i++) {
                currNode.next = new ListNode(arrIntegers[i]);
                currNode = currNode.next;
                // if (arrIntegers[i] != null) {
                currNode.random = new ListNode(arrIntegers[i]);
                // }
            }
            return node;
        }

        public static ListNode[] generateNodeList(int[][] arrIntegers) {
            ListNode[] list = new ListNode[arrIntegers.length];
            for (int i = 0; i < arrIntegers.length; i++) {
                list[i] = generateNode(arrIntegers[i]);
            }
            return list;
        }

        public String toString() {
            ListNode currentNode = this;
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

    // o(n) o(1)
    public ListNode reverseList(ListNode head) {
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

    // O(n) O(n)
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
