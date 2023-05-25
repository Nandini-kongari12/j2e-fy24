import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class graph3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();

        List<Node> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new Node(i + 1));
        }

        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();

        System.out.println("Enter the edges:");
        for (int i = 0; i < m; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.get(source - 1).neighbors.add(graph.get(destination - 1));
        }

        scanner.close();

        List<Node> clonedGraph = cloneGraph(graph);
        System.out.println("Cloned graph:");
        for (Node node : clonedGraph) {
            System.out.print("Node " + node.label + " neighbors: ");
            for (Node neighbor : node.neighbors) {
                System.out.print(neighbor.label + " ");
            }
            System.out.println();
        }
    }

    public static List<Node> cloneGraph(List<Node> graph) {
        if (graph == null || graph.isEmpty()) {
            return new ArrayList<>();
        }

        Map<Node, Node> clonedNodes = new HashMap<>();
        for (Node node : graph) {
            clonedNodes.put(node, new Node(node.label));
        }

        for (Node node : graph) {
            Node clonedNode = clonedNodes.get(node);
            for (Node neighbor : node.neighbors) {
                clonedNode.neighbors.add(clonedNodes.get(neighbor));
            }
        }

        return new ArrayList<>(clonedNodes.values());
    }
}


class Node {
    int label;
    List<Node> neighbors;

    Node(int label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }
}
