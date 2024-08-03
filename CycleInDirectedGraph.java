package GRAPHS;

public class CycleInDirectedGraph {
    public static boolean isVisited(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] pathVisited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int[][] graph, int start, boolean[] visited, boolean[] pathVisited) {
        visited[start] = true;
        pathVisited[start] = true;

        for (int neighbor : graph[start]) {
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[neighbor]) {
                return true;
            }
        }

        pathVisited[start] = false; // Backtrack
        return false;
    }

    public static void main(String[] args) {
        int[][] graph1 = {
            {1},
            {2},
            {0, 3},
            {4},
            {}
        };

        int[][] graph2 = {
                 {1, 2},
                {2},
                {},
                {4},
                {}
        };

        System.out.println("Graph1 has cycle: " + isVisited(graph1)); // Output: true
        System.out.println("Graph2 has cycle: " + isVisited(graph2)); // Output: false
    }
}
