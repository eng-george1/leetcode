package Tree;

import a_Basics.Tree.TreeNode;

public class diameterOfBinaryTree {
    /*
     * https://leetcode.com/problems/diameter-of-binary-tree/description/
     * 543. Diameter of Binary Tree
     * Given the root of a binary tree, return the length of the diameter of the
     * tree.
     * The diameter of a binary tree is the length of the longest path between any
     * two nodes in a tree. This path may or may not pass through the root.
     * The length of a path between two nodes is represented by the number of edges
     * between them.
     * Example 1:
     * Input: root = [1,2,3,4,5]
     * Output: 3
     * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
     * Example 2:
     * Input: root = [1,2]
     * Output: 1
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
     * TC:O(n) SC: O(n) if balanced SC: O(logn)
     */
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }
    private int longestPath(TreeNode node) {
        if (node == null)
            return 0;
        // recursively find the longest path in both left child and right child
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        // update the diameter if left_path plus right_path is larger
        diameter = Math.max(diameter, leftPath + rightPath);

        // return the longest one between left_path and right_path;
        // remember to add 1 for the path connecting the node and its parent
        return Math.max(leftPath, rightPath) + 1;
    }

}