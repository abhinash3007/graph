package GRAPHS;

import java.util.*;

public class NumberOfIsland {
    public static void isLand(char[][] graph) {
        int row = graph.length;
        int col = graph[0].length;
        int count = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(graph, visited, i, j);
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(char[][] graph, boolean[][] visited, int row, int col) {
        if ((row < 0) || (row >= graph.length) || (col < 0) || (col >= graph[0].length) || graph[row][col] == '0'
                || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        dfs(graph, visited, row - 1, col);
        dfs(graph, visited, row, col + 1);
        dfs(graph, visited, row, col - 1);
        dfs(graph, visited, row + 1, col);
    }

    //////////// APPROACH 2 ////////////
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                    numIslands++;
                }
            }
        }
        System.out.println(numIslands);
        return numIslands;
    }

    private static void bfs(char[][] grid, boolean[][] visited, int row, int col) {
        int[] rowNbr = { -1, 0, 0, 1 };
        int[] colNbr = { 0, -1, 1, 0 };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { row, col });
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for (int k = 0; k < 4; k++) {
                int newRow = currRow + rowNbr[k];
                int newCol = currCol + colNbr[k];
                if (isSafe(grid, visited, newRow, newCol)) {
                    queue.add(new int[] { newRow, newCol });
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

    private static boolean isSafe(char[][] grid, boolean[][] visited, int row, int col) {
        return (row >= 0) && (row < grid.length) && (col >= 0) && (col < grid[0].length)
                && (grid[row][col] == '1' && !visited[row][col]);
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        isLand(grid);
        numIslands(grid);

    }
}
