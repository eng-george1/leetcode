package a_Basics.Tree;

import java.util.LinkedList;
import java.util.Queue;

class BinarySearchTree {
    TreeNode root;

    // Method to build BST from array
    public TreeNode buildBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        root = null;
        for (int num : nums) {
            root = insert(root, num);
        }
        return root;
    }

    // Insert method
    private TreeNode insert(TreeNode root, int val) {
        // Base case: if root is null, create new node
        if (root == null) {
            return new TreeNode(val);
        }

        // Recursively insert into appropriate subtree
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Method to build balanced BST from sorted array
    public TreeNode buildBalancedBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return buildBalancedBSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode buildBalancedBSTHelper(int[] nums, int start, int end) {
        if (start > end)
            return null;

        // Get middle element as root
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build left and right subtrees
        root.left = buildBalancedBSTHelper(nums, start, mid - 1);
        root.right = buildBalancedBSTHelper(nums, mid + 1, end);

        return root;
    }

    // Delete a node with given value
    // Average case: O(log n) where n is the number of nodes
    // Worst case: O(h) where h is the height of the tree
    public void delete(int value) {
        root = deleteNode(root, value);
    }

    /*
     * One step right and then always left (greater that) the first number after the
     * deleted one
     */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    /*
     * One step left and then always right (less than) the first number before the
     * deleted one
     */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root.val;
    }

    // Space complexity : O(H) to keep the recursion stack, where H is a tree
    // height. H=logN for the balanced tree.
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        // delete from the right subtree
        if (key > root.val)
            root.right = deleteNode(root.right, key);
        // delete from the left subtree
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null)
                root = null;
            // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    // Utility method to print tree level-order
    public void levelOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                System.out.print(current.val + " ");

                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            System.out.println(); // New line for each level
        }
    }

    // Utility method to print tree in-order
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public LinkedList<Integer> inorder(TreeNode root, LinkedList<Integer> arr) {
        if (root == null)
            return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null)
            return true;
        // one of p and q is null
        if (q == null || p == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Test 1: Regular BST build
        System.out.println("Regular BST from unsorted array:");
        int[] nums1 = { 8, 3, 10, 1, 6, 14, 4, 7, 13 };
        TreeNode root1 = bst.buildBST(nums1);
        System.out.println("Inorder traversal (should be sorted):");
        root1.prettyPrint();
        bst.inorderTraversal(root1);

        // Test 2: Balanced BST from sorted array
        System.out.println("\nBalanced BST from sorted array:");
        int[] nums2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        TreeNode root2 = bst.buildBalancedBST(nums2);
        System.out.println("Inorder traversal:");
        root2.prettyPrint();
        bst.inorderTraversal(root2);

    }
}