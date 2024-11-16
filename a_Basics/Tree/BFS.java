package a_Basics.Tree;

import java.util.*;

public class BFS {
    // BFS can't use recursion
    // BFS for a Binary Tree
    public static void bfs(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // Visit the current node
            System.out.print(node.val + " ");
            // Add the left and right children to the queue
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        System.out.println();
    }

    // BFS for Binary Tree with Level Tracking
    public static void bfsWithLevels(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            System.out.print("Level " + level + ": ");

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");

                // Add the left and right children to the queue
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            System.out.println(); // New line for the next level
            level++;
        }
    }

    // BFS for a Graph
    public void bfsGraph(int start, Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            // Traverse all neighbors
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
  // using recursion to compare left and right 
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
    public static void main(String[] args) {
        Integer[] nodes = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        TreeNode root = TreeNode.buildTree(nodes);
        bfs(root);
    }
}
