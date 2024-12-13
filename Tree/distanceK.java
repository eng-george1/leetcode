package Tree;

import java.util.*;

import a_Basics.Tree.TreeNode;

public class distanceK {
    /*
     * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
     * description/
     * 863. All Nodes Distance K in Binary Tree
     * Given the root of a binary tree, the value of a target node target, and an
     * integer k, return an array of the values of all nodes that have a distance k
     * from the target node.
     * You can return the answer in any order.
     * Example 1:
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
     * Output: [7,4,1]
     * Explanation: The nodes that are a distance 2 from the target node (with value
     * 5) have values 7, 4, and 1.
     * Example 2:
     * Input: root = [1], target = 1, k = 3
     * Output: []
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        Integer[] nodes = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
        TreeNode root = TreeNode.buildTree(nodes);
        System.out.println(distanceK(root, root.left, 2));

        Integer[] nodes1 = { 0, null, 1, null, 2, null, 3 };
        TreeNode root1 = TreeNode.buildTree(nodes1);
        System.out.println(distanceK(root1, root1.right, 2));

        Integer[] nodes2 = { 0, 1, null, 3, 2 };
        TreeNode root2 = TreeNode.buildTree(nodes2);
        System.out.println(distanceK(root2, root2.left.right, 1));
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea: convert the tree to graph but unidirectional by have map with node and
     * its parent and for unidirectional use the visited list
     * the problem more easy if you thing about the node value as unique so no need
     * to trace the node itself use the value
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

    public List<Integer> distanceK01(TreeNode root, TreeNode target, int k) {
        // Step 1: Create a map to store parent pointers of each node
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        dfsAddParents(root, null, parentMap);
        // Step 2: Perform BFS to find all nodes at distance k from target
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (k == 0) {
                for (int i = 0; i < size; i++) {
                    result.add(queue.poll().val);
                }
                return result;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                }
            }
            k--;
        }
        return result;
    }

    private static void dfsAddParents(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null)
            return;
        parentMap.put(node, parent);
        dfsAddParents(node.left, node, parentMap);
        dfsAddParents(node.right, node, parentMap);
    }

    public List<Integer> distanceK02(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        dfs(root, target, k, result);
        return result;
    }

    private int dfs(TreeNode node, TreeNode target, int k, List<Integer> result) {
        if (node == null) {
            return -1;
        }

        if (target == node) {
            findChildren(node, k + 1, result);
            return k;
        } else {
            int leftK = dfs(node.left, target, k, result);
            int rightK = dfs(node.right, target, k, result);

            if (leftK == 1) {
                result.add(node.val);
                return 0;
            } else if (leftK > 1) {
                findChildren(node.right, leftK - 1, result);
                return leftK - 1;
            }
            
            if (rightK == 1) {
                result.add(node.val);
                return 0;
            } else if (rightK > 1) {
                findChildren(node.left, rightK - 1, result);
                return rightK - 1;
            }

            return -1;
        }
    }

    private void findChildren(TreeNode node, int k, List<Integer> result) {
        if (node == null) {
            return;
        }

        if (k == 1) {
            result.add(node.val);
        } else {
            findChildren(node.left, k - 1, result);
            findChildren(node.right, k - 1, result);
        }
    }
}