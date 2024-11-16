package Tree;

import java.util.ArrayList;
import java.util.List;

import a_Basics.Tree.TreeNode;

public class zigzagLevelOrder {
    /*
     * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
     * description/
     * 103. Binary Tree Zigzag Level Order Traversal
     * Given the root of a binary tree, return the zigzag level order traversal of
     * its nodes' values. (i.e., from left to right, then right to left for the next
     * level and alternate between).
     * Example 1:
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[3],[20,9],[15,7]]
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
        Integer[] nodes = { 3, 9, 20, null, null, 15, 7 };
        TreeNode root = TreeNode.buildTree(nodes);
        System.out.println(zigzagLevelOrder(root));

        Integer[] nodes2 = { 1,2,3,4,null,null,5};
        TreeNode root2 = TreeNode.buildTree(nodes2);
        System.out.println(zigzagLevelOrder(root2));

    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea: if odd add 0,node.vale if even add the node.val
     */
  static  List<List<Integer>> ans;

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans = new ArrayList<>();
        recursion(root, 0);
        return ans;
    }

    private static void recursion(TreeNode node, int level) {
        if (node == null)
            return;
        if (ans.size() <= level)
            ans.add(new ArrayList<>());
        if (level % 2 == 0)
            ans.get(level).add(node.val);
        else
            ans.get(level).add(0, node.val);
        recursion(node.left, level + 1);
        recursion(node.right, level + 1);
    }

    
}