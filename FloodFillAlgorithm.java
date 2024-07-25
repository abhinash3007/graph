package GRAPHS;

public class FloodFillAlgorithm {
    public static void flood(int[][] grid, int sr, int sc, int newColor) {
        if (grid[sr][sc]!=newColor) {
            dfs(grid, sr, sc, grid[sr][sc], newColor);
        }
    }

    public static void dfs(int[][] image, int row, int col, int color, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != color) {
            return;
        }
        image[row][col] = newColor;
        dfs(image, row - 1, col, color, newColor); // up
        dfs(image, row + 1, col, color, newColor); // down
        dfs(image, row, col - 1, color, newColor); // left
        dfs(image, row, col + 1, color, newColor); // right
    }
    public static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };flood(image, 1, 1, 2);
        printImage(image);
    }
}
