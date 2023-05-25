import java.util.*;

public class graph9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int numNodes = scanner.nextInt();

        List<int[]> graph = new ArrayList<>();
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter the edges:");
        for (int i = 0; i < numEdges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.add(new int[]{source, destination});
        }

        System.out.print("Enter the source node: ");
        int source = scanner.nextInt();

        System.out.print("Enter the destination node: ");
        int destination = scanner.nextInt();

        int numPaths = findNumberOfPaths(graph, numNodes, source, destination);
        System.out.println("Number of paths from source to destination: " + numPaths);

        scanner.close();
    }

    public static int findNumberOfPaths(List<int[]> graph, int numNodes, int source, int destination) {
        int[] numPaths = new int[numNodes];
        numPaths[source] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int[] edge : graph) {
                int currentSource = edge[0];
                int currentDestination = edge[1];

                if (currentSource == node) {
                    numPaths[currentDestination] += numPaths[currentSource];
                    queue.offer(currentDestination);
                }
            }
        }

        return numPaths[destination];
    }
}