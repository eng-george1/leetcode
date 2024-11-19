package a_Basics.Tree;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    // Method to build the tree from an array
    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0)
            return null;

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < nodes.length) {
            TreeNode current = queue.poll();

            // Left child
            if (nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Pretty print methods
    public void prettyPrint() {
        prettyPrint(this);
    }

    private void prettyPrint(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        // Get the height of the tree
        int height = getHeight(root);

        // Calculate the width needed for displaying the tree
        int width = (1 << height) * 2;

        // Create lists to store node values at each level
        List<List<String>> levels = new ArrayList<>();
        List<List<String>> branches = new ArrayList<>();

        // Populate the levels and branches lists
        populateLevels(root, 0, 0, width, levels, branches);

        // Print the tree
        for (int i = 0; i < levels.size(); i++) {
            printLevel(levels.get(i));
            if (i < branches.size()) {
                printLevel(branches.get(i));
            }
        }
    }

    private void populateLevels(TreeNode node, int level, int offset, int width,
            List<List<String>> levels, List<List<String>> branches) {
        if (node == null)
            return;

        // Ensure we have lists for this level
        while (levels.size() <= level) {
            levels.add(new ArrayList<>());
            if (branches.size() < level) {
                branches.add(new ArrayList<>());
            }
        }

        // Fill in any missing spaces before this node
        while (levels.get(level).size() < offset) {
            levels.get(level).add(" ");
        }

        // Calculate position for this node
        int position = offset + width / 2;
        while (levels.get(level).size() < position) {
            levels.get(level).add(" ");
        }

        // Add the node value
        levels.get(level).add(String.valueOf(node.val));

        // If this node has children, add branches
        if (node.left != null || node.right != null) {
            while (branches.size() <= level) {
                branches.add(new ArrayList<>());
            }

            // Fill branches level with spaces up to this position
            while (branches.get(level).size() < position - 1) {
                branches.get(level).add(" ");
            }

            if (node.left != null) {
                branches.get(level).add("/");
            } else {
                branches.get(level).add(" ");
            }

            if (node.right != null) {
                while (branches.get(level).size() < position + 1) {
                    branches.get(level).add(" ");
                }
                branches.get(level).add("\\");
            }
        }

        // Recursively process children
        int nextWidth = width / 2;
        populateLevels(node.left, level + 1, offset, nextWidth, levels, branches);
        populateLevels(node.right, level + 1, offset + nextWidth, nextWidth, levels, branches);
    }

    private void printLevel(List<String> level) {
        for (String s : level) {
            System.out.print(s);
        }
        System.out.println();
    }

    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}