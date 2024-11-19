package Tree;

import java.util.Stack;

import a_Basics.Tree.TreeNode;

public class recoverTree {
    /*
     * https://leetcode.com/problems/recover-binary-search-tree/description/?envType
     * =problem-list-v2&envId=tree
     * 99. Recover Binary Search Tree
     * You are given the root of a binary search tree (BST), where the values of
     * exactly two nodes of the tree were swapped by mistake. Recover the tree
     * without changing its structure.
     * Example 1:
     * Input: root = [1,3,null,null,2]
     * Output: [3,1,null,null,2]
     * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3
     * makes the BST valid.
     * Example 2:
     * Input: root = [3,1,4,null,null,2]
     * Output: [2,1,4,null,null,3]
     * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2
     * and 3 makes the BST valid.
     * Constraints:
     * The number of nodes in the tree is in the range [2, 1000].
     * -231 <= Node.val <= 231 - 1
     * Follow up: A solution using O(n) space is pretty straight-forward. Could you
     * devise a constant O(1) space solution?
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        Integer[] nodes = { 1, 3, null, null, 2 };
        TreeNode node = TreeNode.buildTree(nodes);
        node.prettyPrint();
        recoverTree(node);
        node.prettyPrint();
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static void recoverTree(TreeNode root) {
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int low = Integer.MIN_VALUE, high = Integer.MAX_VALUE;
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.val > node.val || node.left.val > high)
                    if (firstNode == null)
                        firstNode = node.left;
                    else
                        secondNode = node.left;
                stack.add(node.left);
                high = node.left.val;
            }
            if (node.right != null) {
                if (node.right.val > node.val && node.right.val < low)
                    if (firstNode == null)
                        firstNode = node.left;
                    else
                        secondNode = node.left;
                stack.add(node.right);
                low = node.right.val;
            }
        }
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

    }
}