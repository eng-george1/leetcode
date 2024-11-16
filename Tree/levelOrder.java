package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import a_Basics.Tree.TreeNode;

public class levelOrder {
    /*
     * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
     * 102. Binary Tree Level Order Traversal
     * Given the root of a binary tree, return the level order traversal of its
     * nodes' values. (i.e., from left to right, level by level).
     * Example 1:
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[3],[9,20],[15,7]]
     * Example 2:
     * Input: root = [1]
     * Output: [[1]]
     * Example 3:
     * Input: root = []
     * Output: []
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        Integer[] nodes = { 1, 2, 2, 3, 4, 4, 3 };
        TreeNode root = TreeNode.buildTree(nodes);
        System.out.println(levelOrder(root));

        Integer[] nodes2 = { 1, 2, 2, null, 3, null, 3 };
        TreeNode root2 = TreeNode.buildTree(nodes2);
        System.out.println(levelOrder(root2));

    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // BFS
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> resuList = new ArrayList<>();
        if (root == null) {
            return resuList;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    list.add(node.val);
                    if (node.left != null)
                        q.add(node.left);
                    if (node.right != null)
                        q.add(node.right);
                } else {
                    list.add(null);
                }
            }
            resuList.add(list);
        }
        return resuList;
    }
    //recursion
    public List<List<Integer>> levelOrder01(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level) levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null) helper(node.left, level + 1);
        if (node.right != null) helper(node.right, level + 1);
    }

   
}