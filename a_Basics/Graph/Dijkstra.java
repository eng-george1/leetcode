package a_Basics.Graph;

import java.util.*;

public class Dijkstra {

    // Function to perform Dijkstra's algorithm
    public static int[] dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE
                        && distances[u] + graph[u][v] < distances[v]) {
                    distances[v] = distances[u] + graph[u][v];
                    pq.add(new Node(v, distances[v]));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 10, 0, 30, 100 },
                { 10, 0, 50, 0, 0 },
                { 0, 50, 0, 20, 10 },
                { 30, 0, 20, 0, 60 },
                { 100, 0, 10, 60, 0 }
        };

        int source = 0;
        int[] distances = dijkstra(graph, source);

        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To vertex " + i + " - Distance: " + distances[i]);
        }
    }
}
