package GRAPHS;

public class NumberOfEnclaves {
    public static void enclaves(int[][] graph) {
        int row = graph.length;
        int col = graph[0].length;
        for (int i = 0; i < row; i++) {
            dfs(graph, i, 0);
            dfs(graph, i, col - 1);
        }
        for (int j = 0; j < col; j++) {
            dfs(graph, 0, j);
            dfs(graph, row - 1, j);
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 1) {
                    count++;
                } else if (graph[i][j] == 2) {
                    graph[i][j] = 1;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int[][] graph, int row, int col) {
        if (row < 0 || row >= graph.length || col < 0 || col >= graph[0].length || graph[row][col] != 1) {
            return;
        }
        graph[row][col] = 2;
        dfs(graph, row - 1, col);
        dfs(graph, row, col + 1);
        dfs(graph, row + 1, col);
        dfs(graph, row, col - 1);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0} 
        };
        enclaves(graph);
    }
}
