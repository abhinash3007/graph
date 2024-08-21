package GRAPHS;

public class MinimumCitiesWithThresholdDistance {
    public static void floyd(int[][] graph, int threshold) {
        int n = graph.length;
        int[][] dis = new int[n][n];

        // Initialize the distance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dis[i][j] = 0;
                } else if (graph[i][j] != Integer.MAX_VALUE) {
                    dis[i][j] = graph[i][j];
                } else {
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Floyd-Warshall algorithm to find shortest paths
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[i][via] != Integer.MAX_VALUE && dis[via][j] != Integer.MAX_VALUE) {
                        dis[i][j] = Math.min(dis[i][j], dis[i][via] + dis[via][j]);
                    }
                }
            }
        }

        // Finding the city with the smallest number of neighbors within the threshold distance
        int minCount = Integer.MAX_VALUE;
        int resCity = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dis[i][j] <= threshold) {
                    count++;
                }
            }
            if (count < minCount) {
                minCount = count;
                resCity = i;
            } else if (count == minCount && i < resCity) {
                resCity = i;
            }
        }
        
        // Print the result
        System.out.println(resCity);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {2, 0, Integer.MAX_VALUE, 1},
            {Integer.MAX_VALUE, 7, 0, 2},
            {6, Integer.MAX_VALUE, 8, 0}
        };
        floyd(graph, 4);
    }
}
