package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import a_Basics.Tree.TreeNode;

public class lowestCommonAncestor {
    /*
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
     * description/
     * 236. Lowest Common Ancestor of a Binary Tree
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
     * in the tree.
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor
     * is defined between two nodes p and q as the lowest node in T that has both p
     * and q as descendants (where we allow a node to be a descendant of itself).”
     * Example 1:
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * Output: 3
     * Explanation: The LCA of nodes 5 and 1 is 3.
     * Example 2:
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * Output: 5
     * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
     * of itself according to the LCA definition.
     * Example 3:
     * Input: root = [1,2], p = 1, q = 2
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
     * TC:O(n) SC: O(h) where h the hight of the tree
     */
    // // in case of Balanced Binary tree ( Optimal solution going to be DFS) using
    // recursion.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    // O(n)O(n)
    // incase it is NOT Balanced Binary Tree (Optimal Solution going to be BFS) full
    // scan traversing and save the relations in HashTable.
    public TreeNode lowestCommonAncestor01(TreeNode root, TreeNode p, TreeNode q) {

        Map<TreeNode, TreeNode> parentsMap = getNodesParentsRelationsMap(root);
        Set<TreeNode> pNodesParentsChain = new HashSet<>();

        // get p node parents chain and Have them in set.
        while (p != null) {
            pNodesParentsChain.add(p);
            p = parentsMap.get(p);
        }

        // search to find the parents of node q in side the chain of the p node parents
        // chain.
        while (!pNodesParentsChain.contains(q)) {
            q = parentsMap.get(q);
        }

        // return counter1 + counter2
        return q;
    }

    // building HashTable to save the relations between the nodes to be able to
    // traverse from the children to the parents.
    public Map<TreeNode, TreeNode> getNodesParentsRelationsMap(TreeNode root) {
        Map<TreeNode, TreeNode> parentsMap = new HashMap<>();
        parentsMap.put(root, null);

        // queue for BFS Traversing
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();

            if (currentNode.left != null) {
                queue.add(currentNode.left);
                parentsMap.put(currentNode.left, currentNode);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
                parentsMap.put(currentNode.right, currentNode);
            }
        }

        return parentsMap;
    }
}