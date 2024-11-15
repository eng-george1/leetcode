package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

import a_Basics.Pair;
import a_Basics.stack;

public class orangesRotting {
    /*
     * https://leetcode.com/problems/rotting-oranges/description/
     * 994. Rotting Oranges
     * You are given an m x n grid where each cell can have one of three values:
     * 0 representing an empty cell,
     * 1 representing a fresh orange, or
     * 2 representing a rotten orange.
     * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
     * orange becomes rotten.
     * Return the minimum number of minutes that must elapse until no cell has a
     * fresh orange. If this is impossible, return -1.
     * Example 1:
     * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
     * Output: 4
     * Example 2:
     * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
     * Output: -1
     * Explanation: The orange in the bottom left corner (row 2, column 0) is never
     * rotten, because rotting only happens 4-directionally.
     * Example 3:
     * Input: grid = [[0,2]]
     * Output: 0
     * Explanation: Since there are already no fresh oranges at minute 0, the answer
     * is just 0.
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    /*
     * TC:O(n m) SC: O(nm)
     * #Notes
     * #LastReview
     * #Review
     * #Idea: using the BFS and have count for the fresh and every change in the status fresh-- 
     */   
    public int orangesRotting1(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque();

        // Step 1). build the initial set of rotten oranges
        int freshOranges = 0;
        int ROWS = grid.length, COLS = grid[0].length;

        for (int r = 0; r < ROWS; ++r)
            for (int c = 0; c < COLS; ++c)
                if (grid[r][c] == 2)
                    queue.offer(new Pair(r, c));
                else if (grid[r][c] == 1)
                    freshOranges++;

        // Mark the round / level, _i.e_ the ticker of timestamp
        queue.offer(new Pair(-1, -1));

        // Step 2). start the rotting process via BFS
        int minutesElapsed = -1;
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            int row = p.getKey();
            int col = p.getValue();
            if (row == -1) {
                // We finish one round of processing
                minutesElapsed++;
                // to avoid the endless loop
                if (!queue.isEmpty())
                    queue.offer(new Pair(-1, -1));
            } else {
                // this is a rotten orange
                // then it would contaminate its neighbors
                for (int[] d : directions) {
                    int neighborRow = row + d[0];
                    int neighborCol = col + d[1];
                    if (neighborRow >= 0 && neighborRow < ROWS &&
                            neighborCol >= 0 && neighborCol < COLS) {
                        if (grid[neighborRow][neighborCol] == 1) {
                            // this orange would be contaminated
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            // this orange would then contaminate other oranges
                            queue.offer(new Pair(neighborRow, neighborCol));
                        }
                    }
                }
            }
        }

        // return elapsed minutes if no fresh orange left
        return freshOranges == 0 ? minutesElapsed : -1;
    }
    //O(N^2m^2) S:o(1) WITHOUT USING queue we use the grid with iteration stamp by replace insted of 2 replace 3 in the first iteration (i+2)
    // run the rotting process, by marking the rotten oranges with the timestamp
    public boolean runRottingProcess(int timestamp, int[][] grid, int ROWS, int COLS) {
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        // flag to indicate if the rotting process should be continued
        boolean toBeContinued = false;
        for (int row = 0; row < ROWS; ++row)
            for (int col = 0; col < COLS; ++col)
                if (grid[row][col] == timestamp)
                    // current contaminated cell
                    for (int[] d : directions) {
                        int nRow = row + d[0], nCol = col + d[1];
                        if (nRow >= 0 && nRow < ROWS && nCol >= 0 && nCol < COLS)
                            if (grid[nRow][nCol] == 1) {
                                // this fresh orange would be contaminated next
                                grid[nRow][nCol] = timestamp + 1;
                                toBeContinued = true;
                            }
                    }
        return toBeContinued;
    }

    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int timestamp = 2;
        while (runRottingProcess(timestamp, grid, ROWS, COLS))
            timestamp++;

        // end of process, to check if there are still fresh oranges left
        for (int[] row : grid)
            for (int cell : row)
                // still got a fresh orange left
                if (cell == 1)
                    return -1;

        // return elapsed minutes if no fresh orange left
        return timestamp - 2;
    }

}