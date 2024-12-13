package Tree;

import java.util.*;

import a_Basics.Pair;
import a_Basics.Tree.TreeNode;

public class verticalTraversal {
    /*
     * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
     * description/
     * 987. Vertical Order Traversal of a Binary Tree
     * Given the root of a binary tree, calculate the vertical order traversal of
     * the binary tree.
     * For each node at position (row, col), its left and right children will be at
     * positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of
     * the tree is at (0, 0).
     * The vertical order traversal of a binary tree is a list of top-to-bottom
     * orderings for each column index starting from the leftmost column and ending
     * on the rightmost column. There may be multiple nodes in the same row and same
     * column. In such a case, sort these nodes by their values.
     * Return the vertical order traversal of the binary tree.
     * Example 1:
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[9],[3,15],[20],[7]]
     * Explanation:
     * Column -1: Only node 9 is in this column.
     * Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
     * Column 1: Only node 20 is in this column.
     * Column 2: Only node 7 is in this column.
     * Example 2:
     * Input: root = [1,2,3,4,5,6,7]
     * Output: [[4],[2],[1,5,6],[3],[7]]
     * Explanation:
     * Column -2: Only node 4 is in this column.
     * Column -1: Only node 2 is in this column.
     * Column 0: Nodes 1, 5, and 6 are in this column.
     * 1 is at the top, so it comes first.
     * 5 and 6 are at the same position (2, 0), so we order them by their value, 5
     * before 6.
     * Column 1: Only node 3 is in this column.
     * Column 2: Only node 7 is in this column.
     * Example 3:
     * Input: root = [1,2,3,4,6,5,7]
     * Output: [[4],[2],[1,5,6],[3],[7]]
     * Explanation:
     * This case is the exact same as example 2, but with nodes 5 and 6 swapped.
     * Note that the solution remains the same since 5 and 6 are in the same
     * location and should be ordered by their values.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        // Create the tree for input root = [1,2,3,4,6,5,7]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        // Expected Output: [[4], [2], [1, 5, 6], [3], [7]]
        List<List<Integer>> result = verticalTraversal.verticalTraversal(root);
        System.out.println(result); // Should print [[4], [2], [1, 5, 6], [3], [7]]
    }

    /*
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:O(nlogn) SC: O(n)
     */
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        Map<Integer, ArrayList<int[]>> columnTable = new HashMap<>();
        Queue<Pair<TreeNode, int[]>> queue = new ArrayDeque<>();
        int column = 0;
        queue.offer(new Pair<>(root, new int[] { column, 0 }));
        int minColumn = 0, maxColumn = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, int[]> p = queue.poll();
            TreeNode node = p.getKey();
            column = p.getValue()[0];
            int row = p.getValue()[1];
            if (node != null) {
                columnTable.computeIfAbsent(column, k -> new ArrayList<>()).add(new int[] { row, node.val });
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);
                queue.offer(new Pair<>(node.left, new int[] { column - 1, row + 1 }));
                queue.offer(new Pair<>(node.right, new int[] { column + 1, row + 1 }));
            }
        }
        for (int i = minColumn; i <= maxColumn; ++i) {
            if (columnTable.containsKey(i)) {
                columnTable.get(i).sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
                List<Integer> sortedColumn = new ArrayList<>();
                for (int[] p : columnTable.get(i)) {
                    sortedColumn.add(p[1]);
                }
                output.add(sortedColumn);
            }
        }
        return output;
    }



    PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>();
	public List<List<Integer>> verticalTraversal01(TreeNode root) {
		traverse(root, 0, 0);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(new ArrayList<Integer>());
		int col = queue.peek().col;
		while(!queue.isEmpty()) {
			Tuple tuple = queue.poll();
			if(tuple.col != col) {
				col = tuple.col;
				list.add(new ArrayList<Integer>());
			}
			list.getLast().add(tuple.val);
		}
		return list;
		
	}
	public void traverse(TreeNode node, int row , int col) {
		if(node == null)
			return ;
		queue.add(new Tuple(node.val, row, col));
		traverse(node.left, row+1, col-1);
		traverse(node.right, row+1, col+1);
	}
	class Tuple implements Comparable<Tuple>{
		public Tuple(int val, int row, int col) {
			super();
			this.val = val;
			this.row = row;
			this.col = col;
		}
		int val; 
		int row;
		int col;
		@Override
		public int compareTo(Tuple o) {
			if(o.col != this.col)
				return this.col-o.col;
			if(o.row!=this.row)
				return this.row-o.row;
			return this.val-o.val;
		}
		@Override
		public String toString() {
			return "[val=" + val + ", row=" + row + ", col=" + col + "]";
		}
		
	}
}
