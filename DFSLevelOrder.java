import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class DFSLevelOrder {
    public static void dfs(TreeNode root, int level, Map<Integer, List<Integer>> levels) {
        if (root == null) return;

        levels.putIfAbsent(level, new ArrayList<>());
        levels.get(level).add(root.val);

        dfs(root.left, level + 1, levels);
        dfs(root.right, level + 1, levels);
    }

    public static void printLevels(TreeNode root) {
        Map<Integer, List<Integer>> levels = new HashMap<>();
        dfs(root, 0, levels);
        
        for (int i = 0; i < levels.size(); i++) {
            System.out.println("Level " + i + ": " + levels.get(i));
        }
    }
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        dfsRecursive(root,0);
    }
}
