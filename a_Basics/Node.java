package a_Basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    private final Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return cloneGraphDFS(node);
    }
    private Node cloneGraphDFS(Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node copy = new Node(node.val);
        map.put(node, copy);
        for (var n : node.neighbors) {
            copy.neighbors.add(cloneGraphDFS(n));
        }
        return copy;
    }

    public Node cloneGraphBFS(Node node) {
        if (node == null) {
            return node;
        }
        HashMap<Node, Node> visited = new HashMap();
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList()));
        // Start BFS traversal
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    queue.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}
