package GRAPHS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
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

    public static void minimum(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        for (int[] r : dist) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.dis));
        pq.add(new Cell(0, 0, 0));

        int[] rowD = {-1, 0, 1, 0};
        int[] colD = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Cell current = pq.remove();

            if (current.row == rows - 1 && current.col == cols - 1) {
                System.out.println(current.dis);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newR = current.row + rowD[i];
                int newC = current.col + colD[i];

                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols) {
                    int newEffort = Math.max(current.dis, Math.abs(heights[newR][newC] - heights[current.row][current.col]));
                    if (newEffort < dist[newR][newC]) {
                        dist[newR][newC] = newEffort;
                        pq.add(new Cell(newR, newC, newEffort));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights = {
            {1, 2, 2},
            {3, 8, 2},
            {5, 3, 5}
        };
        minimum(heights);
    }
}
