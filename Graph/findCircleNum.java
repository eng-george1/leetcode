package Graph;

public class findCircleNum {
    /*
     * https://leetcode.com/problems/number-of-provinces/description/
     * 547. Number of Provinces
     * There are n cities. Some of them are connected, while some are not. If city a
     * is connected directly with city b, and city b is connected directly with city
     * c, then city a is connected indirectly with city c.
     * A province is a group of directly or indirectly connected cities and no other
     * cities outside of the group.
     * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
     * ith city and the jth city are directly connected, and isConnected[i][j] = 0
     * otherwise.
     * Return the total number of provinces.
     * Example 1:
     * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * Output: 2
     * Example 2:
     * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * Output: 3
     * #PatchNo
     */
    public static void main(String[] args) {
        System.out.println("Hello");
                // Example test case
                int[][] isConnected = {
                    {1, 1, 0},
                    {1, 1, 0},
                    {0, 0, 1}
                };
        
                int result = findCircleNum(isConnected);
                System.out.println("Number of connected components: " + result); // Output: 2
      
    }

    /*
     * #Notes
     * #LastReview
     * #Review
     * #Idea:
     * TC:O(n^2) SC: O(n)
     */
    public static  int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfComponents++;
                dfs(i, isConnected, visit);
            }
        }

        return numberOfComponents;
    }
    public static void dfs(int node, int[][] isConnected, boolean[] visit) {
        visit[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) {
                dfs(i, isConnected, visit);
            }
        }
    }   
}