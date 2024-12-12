package Graph;

import java.sql.Time;
import java.util.*;

public class canFinish {
    /*
     * https://leetcode.com/problems/course-schedule/description/
     * 207. Course Schedule
     * There are a total of numCourses courses you have to take, labeled from 0 to
     * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
     * [ai, bi] indicates that you must take course bi first if you want to take
     * course ai.
     * For example, the pair [0, 1], indicates that to take course 0 you have to
     * first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     * Example 1:
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you
     * should also have finished course 1. So it is impossible.
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
    // Topological Sort Using Kahn's Algorithm
    // Here, n be the number of courses and m be the size of prerequisites.
    // Time complexity: O(m+n), Space complexity: O(m+n)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Array to store the in-degree (number of incoming edges) of each course.
        int[] indegree = new int[numCourses];

        // Adjacency list to represent the directed graph, where adj.get(i) contains
        // a list of courses that depend on course 'i'.
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list and in-degree array based on prerequisites.
        // prerequisites[i] = [b, a] means to take course 'b', you must first take
        // course 'a'.
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]); // Add edge a -> b
            indegree[prerequisite[0]]++; // Increment in-degree of course 'b'
        }

        // Queue to store courses with an in-degree of 0 (i.e., no prerequisites).
        Queue<Integer> queue = new LinkedList<>();

        // Add all courses with an in-degree of 0 to the queue, as they can be taken
        // immediately.
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        // Counter to keep track of the number of courses that have been "visited"
        // (i.e., can be taken).
        int nodesVisited = 0;

        // Perform BFS-like traversal over the graph.
        while (!queue.isEmpty()) {
            int node = queue.poll(); // Get the next course with no prerequisites.
            nodesVisited++; // Increment the count of courses that can be taken.

            // For each course that depends on the current course:
            for (int neighbor : adj.get(node)) {
                // "Remove" the edge from the current course to its dependent course by
                // decrementing in-degree.
                indegree[neighbor]--;

                // If the in-degree of the dependent course becomes 0, it can now be taken.
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor); // Add it to the queue for further processing.
                }
            }
        }
        // If all courses have been visited, it means we can finish all courses.
        return nodesVisited == numCourses;
    }

}