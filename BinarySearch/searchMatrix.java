package BinarySearch;
//package ;
public class searchMatrix {
    /*
     * https://leetcode.com/problems/search-a-2d-matrix/description/
     * 74. Search a 2D Matrix
     * You are given an m x n integer matrix matrix with the following two
     * properties:
     * Each row is sorted in non-decreasing order.
     * The first integer of each row is greater than the last integer of the
     * previous row.
     * Given an integer target, return true if target is in matrix or false
     * otherwise.
     * You must write a solution in O(log(m * n)) time complexity.
     * Example 1:
     * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * Output: true
     * Example 2:
     * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * Output: false
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 50 }
        };

        // Test Cases
        System.out.println("Test Case 1 (target=3): " + searchMatrix(matrix, 3)); // true
        System.out.println("Test Case 2 (target=13): " + searchMatrix(matrix, 13)); // false
        System.out.println("Test Case 3 (target=50): " + searchMatrix(matrix, 50)); // true
        System.out.println("Test Case 1 (target=3): " + searchMatrix(matrix, 1)); // true
        System.out.println("Test Case 4 (Empty matrix): " + searchMatrix(new int[][] {}, 1)); // false
        System.out.println("Test Case 5 (Empty rows): " + searchMatrix(new int[][] { {} }, 1)); // false
        System.out.println("Test Case 6 (Single element present): " + searchMatrix(new int[][] { { 5 } }, 5)); // true
        System.out.println("Test Case 7 (Single element absent): " + searchMatrix(new int[][] { { 5 } }, 3)); // false

    }

    /*
     * TC:O(logm*n) SC: O(1)
     * #Notes
     * #LastReview
     * #Review
     * #Idea: deal as a one dimension array and use  int midv = matrix[(mid) / matrix[0].length][(mid) % matrix[0].length];
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        return searchMatrix(matrix, 0, matrix.length * matrix[0].length - 1, target);
    }

    private static boolean searchMatrix(int[][] matrix, int left, int right, int target) {
        if (left > right)
            return false;
        int mid = left + (right - left) / 2;
        int midv = matrix[(mid) / matrix[0].length][(mid) % matrix[0].length];
        if (midv == target)
            return true;
        if (midv > target)
            return searchMatrix(matrix, left, mid - 1, target);
        return searchMatrix(matrix, mid + 1, right, target);
    }
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // binary search
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }
}