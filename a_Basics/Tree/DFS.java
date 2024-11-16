package a_Basics.Tree;

import java.util.ArrayList;
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

    // if you want to define the level
    public static void dfsIterativeLevel(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // Get the current level size (nodes in the current level)
            int levelSize = stack.size();
            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = stack.pop();
                System.out.print(node.val + " ");
                // Push the right child first so that the left child is processed first
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            }
            System.out.println(); // New line for the next level
        }
    }

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
