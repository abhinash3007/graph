package GRAPHS;

import java.util.*;

public class NumberOfDistinctIsland {
    public static void distinct(int[][]graph){
        int row=graph.length;
        int col=graph[0].length;
        boolean[][]visited=new boolean[row][col];
        Set<String>unique=new HashSet<>();
        for (int i = 0; i < row; i++) {
            for(int j=0;j<col;j++){
                if (graph[i][j]==1 && !visited[i][j]) {
                    StringBuilder shape = new StringBuilder();
                    dfs(graph,visited,i,j,i,j,shape);
                    unique.add(shape.toString());
                }
            }
        }System.out.println(unique.size());
    }public static void dfs(int[][]graph,boolean[][]visited,int row,int col,int baseR,int baseC,StringBuilder shape){
        if(row<0 || row>=graph.length || col<0 || col>=graph[0].length || graph[row][col]!=1 || visited[row][col]){
            return;
        }
        visited[row][col]=true;
        shape.append((row-baseR)+" "+(col-baseC));
        dfs(graph, visited, row-1, col, baseR, baseC, shape);
        dfs(graph, visited, row, col+1, baseR, baseC, shape);
        dfs(graph, visited, row+1, col, baseR, baseC, shape);
        dfs(graph, visited, row, col-1, baseR, baseC, shape);
    } public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1}
        };distinct(grid);
    }
}
