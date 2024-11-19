package Tree;

import java.util.LinkedList;
import java.util.Queue;

import SlidingWindow.numberOfSubarrays;
import a_Basics.Tree.TreeNode;

public class isSymmetric {
    /*
     * https://leetcode.com/problems/symmetric-tree/description/
     * 101. Symmetric Tree
     * Given the root of a binary tree, check whether it is a mirror of itself
     * (i.e., symmetric around its center).
     * Example 1:
     * Input: root = [1,2,2,3,4,4,3]
     * Output: true
     * Example 2:
     * Input: root = [1,2,2,null,3,null,3]
     * Output: false
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        Integer[] nodes = { 1, 2, 2, 3, 4, 4, 3 };
        TreeNode root = TreeNode.buildTree(nodes);
        System.out.println(isSymmetric(root));

        Integer[] nodes2 = { 1, 2, 2, null, 3, null, 3 };
        TreeNode root2 = TreeNode.buildTree(nodes2);
        System.out.println(isSymmetric(root2));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:Mirror use recursion or iterative 
     */
    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);
        while (!q1.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            if (!((n1 != null && n2 != null && n1.val == n2.val) || (n1 == null && n2 == null))) {
                return false;
            }
            if (n1 != null) {
                q1.add(n1.left);
                q1.add(n1.right);
            }
            if (n2 != null) {
                q2.add(n2.right);
                q2.add(n2.left);
            }

        }
        return true;
    }

    // using recursion #Need-Memorize
    public boolean isSymmetric01(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        return ((t1.val == t2.val) &&
                isMirror(t1.right, t2.left) &&
                isMirror(t1.left, t2.right));
    }
}