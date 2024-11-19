package Tree;

import java.util.ArrayList;
import java.util.List;

import a_Basics.Tree.TreeNode;

public class generateTrees {
    /*
     * https://leetcode.com/problems/unique-binary-search-trees-ii/description/?
     * envType=problem-list-v2&envId=tree
     * 95. Unique Binary Search Trees II
     * Given an integer n, return all the structurally unique BST's (binary search
     * trees), which has exactly n nodes of unique values from 1 to n. Return the
     * answer in any order.
     * Example 1:
     * Input: n = 3
     * Output:
     * [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
     * Example 2:
     * Input: n = 1
     * Output: [[1]]
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n) SC: O(n)
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     */
    // Need-Memorize
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generateTreesHelper(1, n);
    }

    private List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        // Base case: if start > end, add null to result
        if (start > end) {
            result.add(null);
            return result;
        }

        // Try each number as root from start to end
        for (int i = start; i <= end; i++) {
            // Generate all possible left subtrees
            List<TreeNode> leftSubtrees = generateTreesHelper(start, i - 1);

            // Generate all possible right subtrees
            List<TreeNode> rightSubtrees = generateTreesHelper(i + 1, end);

            // Combine left and right subtrees with current root
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }

}