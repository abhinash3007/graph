package GRAPHS;

import java.util.*;

public class RottenOranges {
    public static void rotten(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int notRotten = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    notRotten++;
                }
            }
        }
        if (notRotten == 0) {
            System.out.println("0");
            return;
        }
        int min = -1;
        int[] rowD = { -1, 0, 0, 1 };
        int[] colD = { 0, -1, 1, 0 };
        while (!q.isEmpty()) {
            int size = q.size();
            min++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.remove();
                int currR = cur[0];
                int currC = cur[1];
                for (int k = 0; k < 4; k++) {
                    int newR = currR + rowD[k];
                    int newC = currC + colD[k];
                    if (newR >= 0 && newR < row && newC >= 0 && newC < col && grid[newR][newC] == 1
                            && !visited[newR][newC]) {
                        grid[newR][newC] = 2;
                        q.add(new int[] { newR, newC });
                        visited[newR][newC] = true;
                        notRotten--;
                    }
                }
            }

        }
        if (notRotten > 0) {
            System.out.println("-1");
        } else {
            System.out.println(min);
        } 
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        rotten(grid);
    }
}
