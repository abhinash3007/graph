package GRAPHS;

import java.util.*;

public class ShortestDistanceinaBinaryMaze {
    public static class Cell {
        int row;
        int col;
        int dis;

        Cell(int row, int col, int dis) {
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }

    public static void shortest(int[][] grid, int[] start, int[] end) {
        if (grid[start[0]][start[1]] == 0 || grid[end[0]][end[1]] == 0) {
            System.out.println("The start or end cell is blocked.");
            return;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dist = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        Queue<Cell> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        int[] rowD = {-1, 0, 1, 0};
        int[] colD = {0, 1, 0, -1};

        q.add(new Cell(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        dist[start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            Cell current = q.remove();

            if (current.row == end[0] && current.col == end[1]) {
                System.out.println("Shortest path length: " + current.dis);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newR = current.row + rowD[i];
                int newC = current.col + colD[i];

                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] == 1 && !visited[newR][newC] && dist[newR][newC]==Integer.MAX_VALUE) {
                    q.add(new Cell(newR, newC, current.dis + 1));
                    visited[newR][newC] = true;
                    dist[newR][newC] = current.dis + 1;
                }
            }
        }

        System.out.println("Destination is not reachable.");
    }


    public static void main(String[] args) {
        int[][] maze = {
            {1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 0}
        };
        int[] start = {0, 1};
        int[] end = {2, 2};
        shortest(maze, start, end);
        int[][] maze2 = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0}
        };
        int[] start2 = {0, 0};
        int[] end2 = {4, 4};
        shortest(maze2, start2, end2);
    }
}
