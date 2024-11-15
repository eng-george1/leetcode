package Tree;

import java.util.LinkedList;
import java.util.Queue;

import a_Basics.TreeNode;

public class isValidBST {
    /*
     * https://leetcode.com/problems/validate-binary-search-tree/description/
     * 98. Validate Binary Search Tree
     * Given the root of a binary tree, determine if it is a valid binary search
     * tree (BST).
     * A valid BST is defined as follows:
     * The left
     * subtree
     * of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the
     * node's key.
     * Both the left and right subtrees must also be binary search trees.
     * Example 1:
     * Input: root = [2,1,3]
     * Output: true
     * Example 2:
     * Input: root = [5,1,4,null,null,3,6]
     * Output: false
     * Explanation: The root node's value is 5 but its right child's value is 4.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        Integer[] nodes = { 5, 1, 4, null, null, 3, 6 };
        TreeNode root = TreeNode.buildTree(nodes);
        System.out.println(isValidBST(root));
        Integer[] nodes1 = { 2, 2, 2 };
        TreeNode root1 = TreeNode.buildTree(nodes1);
        System.out.println(isValidBST(root1));
        Integer[] nodes2 = { 5, 4, 6, null, null, null, 7 };
        TreeNode root2 = TreeNode.buildTree(nodes2);
        System.out.println(isValidBST(root2));

    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
     // O(n) O(n)
    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public static boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }

        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) ||
                (high != null && root.val >= high)) {
            return false;
        }

        // The left and right subtree must also be valid.
        return (validate(root.right, root.val, high) &&
                validate(root.left, low, root.val));
    }
}