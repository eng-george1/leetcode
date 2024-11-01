//package ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javax.swing.tree.TreeNode;

public class distanceK {
    /*
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        Integer[] nodes = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
        TreeNode root = buildTree(nodes);
        System.out.println(distanceK(root, root.left, 2));

        Integer[] nodes1 = { 0, null, 1, null, 2, null, 3 };
        TreeNode root1 = buildTree(nodes1);
        System.out.println(distanceK(root1, root1.right, 2));

        Integer[] nodes2 = { 0, 1, null, 3, 2 };
        TreeNode root2 = buildTree(nodes2);
        System.out.println(distanceK(root2, root2.left.right, 1));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea: convert the tree to graph but unidirectional by have map with node and its parent and for unidirectional use the visited list 
     * the problem more easy if you thing about the node value as unique so no need to trace the node itself use the value
     */
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        // build the graph
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root, null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                map.put(node.left, node);
            }
            if (node.right != null) {
                queue.add(node.right);
                map.put(node.right, node);
            }
        }
        List<Integer> answer = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        // Add the target node to the queue with a distance of 0
        queue1.add(target);
        visited.add(target);
        while (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue1.poll();
                if (k != 0) {
                    if (node.left != null && !visited.contains(node.left)) {
                        queue1.add(node.left);
                        visited.add(node.left);
                    }
                    if (node.right != null && !visited.contains(node.right)) {
                        queue1.add(node.right);
                        visited.add(node.right);
                    }
                    // parent
                    if (map.get(node) != null && !visited.contains(map.get(node))) {
                        queue1.add(map.get(node));
                        visited.add(map.get(node));
                    }
                } else {
                    // print
                    answer.add(node.val);
                }
            }
            k--;
        }
        return answer;
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
}