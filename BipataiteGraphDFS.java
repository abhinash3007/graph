package GRAPHS;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BipataiteGraphDFS {
    public static boolean bipartite(int[][]graph){
        int[]color=new int[graph.length];
        Arrays.fill(color, 0);
        for (int i = 0; i < graph.length; i++) {
            if(color[i]==0){
                if(!dfs(graph, i, color, 1)){
                    return false;
                }    
            }
        }return true;
    }public static boolean dfs(int[][]graph,int start,int[]color,int col){
        color[start]=col;
        for(int neighbour:graph[start]){
            if (color[neighbour]==0) {
                if(!dfs(graph, neighbour, color, -col)){
                    return false;
                }
            }else if(color[neighbour]==col){
                return false;
            }
        }return true;
    }public static void main(String[] args) {
        int[][]graph={
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };System.out.println(bipartite(graph));
    }
}
