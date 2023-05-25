import java.util.*;

class DAG {
    private int vertices;
    private List<Integer>[] adjacencyList;

    DAG(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v) {
        adjacencyList[u - 1].add(v - 1);
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (Integer neighbor : adjacencyList[v]) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, visited, stack);
            }
        }

        stack.push(v);
    }

    private int[] topologicalSort() {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        int[] order = new int[vertices];
        int index = 0;
        while (!stack.isEmpty()) {
            order[index++] = stack.pop();
        }

        return order;
    }

    int longestPath(int source, int destination) {
        int[] topologicalOrder = topologicalSort();
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[source - 1] = 0;

        for (int i = 0; i < vertices; i++) {
            int currentVertex = topologicalOrder[i];

            if (dist[currentVertex] != Integer.MIN_VALUE) {
                for (Integer neighbor : adjacencyList[currentVertex]) {
                    if (dist[neighbor] < dist[currentVertex] + 1) {
                        dist[neighbor] = dist[currentVertex] + 1;
                    }
                }
            }
        }

        return dist[destination - 1];
    }
}

public class graph1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        Set<Integer> verticesSet = new HashSet<>();
        System.out.println("Enter the edges in the format 'u v':");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            verticesSet.add(u);
            verticesSet.add(v);
        }

        int vertices = verticesSet.size();
        DAG graph = new DAG(vertices);

        System.out.println("Enter the edges again for adding to the graph:");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        System.out.print("Enter the source vertex: ");
        int source = scanner.nextInt();

        System.out.print("Enter the destination vertex: ");
        int destination = scanner.nextInt();

        int longestPath = graph.longestPath(source, destination);
        System.out.println("Longest path between " + source + " and " + destination + " is: " + longestPath);

        scanner.close();
    }
}
