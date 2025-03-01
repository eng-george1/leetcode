package BinarySearch;

import java.util.ArrayList;
import java.util.List;

import a_Basics.Tree.TreeNode;

public class balanceBST {
    /*
     * https://leetcode.com/problems/balance-a-binary-search-tree/description/
     * 1382. Balance a Binary Search Tree
     * Given the root of a binary search tree, return a balanced binary search tree
     * with the same node values. If there is more than one answer, return any of
     * them.
     * A binary search tree is balanced if the depth of the two subtrees of every
     * node never differs by more than 1.
     * Example 1:
     * Input: root = [1,null,2,null,3,null,4,null,null]
     * Output: [2,1,3,null,null,null,4]
     * Explanation: This is not the only correct answer, [3,1,4,null,2] is also
     * correct.
     * Example 2:
     * Input: root = [2,1,3]
     * Output: [2,1,3]
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:O(n) SC: O(n)
     */
    public TreeNode balanceBST(TreeNode root) {
        // Create a list to store the inOrder traversal of the BST
        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root, inOrder);
        // Construct and return the balanced BST
        return createBalancedBST(inOrder, 0, inOrder.size() - 1);
    }
    private void inOrderTraversal(TreeNode root, List<Integer> inOrder) {
        // Perform an inOrder traversal to store the elements in sorted order
        if (root == null)
            return;
        inOrderTraversal(root.left, inOrder);
        inOrder.add(root.val);
        inOrderTraversal(root.right, inOrder);
    }
    private TreeNode createBalancedBST(List<Integer> inOrder, int start, int end) {
        // Base case: if the start index is greater than the end index, return null
        if (start > end)
            return null;
        // Find the middle element of the current range
        int mid = start + (end - start) / 2;
        // Recursively construct the left and right subtrees
        TreeNode leftSubtree = createBalancedBST(inOrder, start, mid - 1);
        TreeNode rightSubtree = createBalancedBST(inOrder, mid + 1, end);
        // Create a new node with the middle element and attach the subtrees
        TreeNode node = new TreeNode(inOrder.get(mid),leftSubtree,rightSubtree);
        return node;
    }
}
