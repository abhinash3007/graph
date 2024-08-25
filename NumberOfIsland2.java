package GRAPHS;

import java.util.*;

public class NumberOfIsland2 {
    static int[] parent;
    static int[] rank;

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int x, int y) {
        int parX = find(x);
        int parY = find(y);
        if (parX != parY) {
            if (rank[parX] > rank[parY]) {
                parent[parY] = parX;
            } else if (rank[parY] > rank[parX]) {
                parent[parX] = parY;
            } else {
                parent[parY] = parX;
                rank[parX]++;
            }
        }
    }

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        parent = new int[m * n];
        rank = new int[m * n];
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        List<Integer> result = new ArrayList<>();

        for (int[] land : positions) {
            int row = land[0];
            int col = land[1];
            if (visited[row][col]) {
                result.add(count);
                continue;
            }

            int index = row * n + col;
            parent[index] = index;
            rank[index] = 0;
            visited[row][col] = true;
            count++;

            int[] rowD = {-1, 0, 1, 0};
            int[] colD = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                int newRow = row + rowD[i];
                int newCol = col + colD[i];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && visited[newRow][newCol]) {
                    int newIndex = newRow * n + newCol;
                    if (find(index) != find(newIndex)) {
                        union(index, newIndex);
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] positions = { {0, 0}, {1, 1}, {2, 2}, {1, 0}, {2, 1} };
        int m = 3, n = 3;
        List<Integer> result = numIslands2(m, n, positions);
        System.out.println(result); // Output the number of islands after each addition
    }
}
