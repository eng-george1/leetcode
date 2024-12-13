package a_Basics.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DFS {

    public static void dfs(TreeNode node) {
        if (node == null)
            return;
        // Visit the root node
        System.out.print(node.val + " ");
        // Recursively visit the left subtree
        dfs(node.left);
        // Recursively visit the right subtree
        dfs(node.right);
    }

    public static void dfsIterative(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // Visit the current node
            System.out.print(node.val + " ");
            // Push the right child first so that the left child is processed first
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }

    // You can't use DFS to print level by level the oly way to save in map and after
    // finish traverse all tree print
    // call with root,0
    public static void dfsRecursive(TreeNode node, int level) {
        if (node == null)
            return;
        // Print the current node with its level
        System.out.println("Level " + level + ": " + node.val);
        // Recursively visit the left subtree with level + 1
        dfsRecursive(node.left, level + 1);
        // Recursively visit the right subtree with level + 1
        dfsRecursive(node.right, level + 1);
    }

    // convert tree to two ways direction(graph) buy adding parent to each node so
    // you can get the child and the parent
    // Method to add parent pointers using HashMap
    public static void addParentPointers(TreeNode root) {
        if (root == null)
            return;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        dfsAddParents(root, null, parentMap);
    }

    private static void dfsAddParents(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null)
            return;
        parentMap.put(node, parent);
        dfsAddParents(node.left, node, parentMap);
        dfsAddParents(node.right, node, parentMap);
    }

    // Graph
    void dfsGraphIterative(int start, Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                System.out.print(node + " ");
                visited.add(node);
                for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
