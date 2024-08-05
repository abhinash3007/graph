package GRAPHS;

import java.util.Stack;

public class TopologicalSort {
    public static void topo(int[][]graph){
        boolean[]vis=new boolean[graph.length];
        Stack<Integer>s=new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfs(graph,i,vis,s);
            }
        }while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        } 
    }public static void dfs(int[][]graph,int start,boolean[]vis,Stack<Integer>s){
        vis[start]=true;
        for(int neighbour:graph[start]){
            if (!vis[neighbour]) {
                dfs(graph, neighbour, vis, s);
            }
        }s.push(start);
    }public static void main(String[] args) {
        int[][] graph = {
            {},
            {},
            {3},
            {1},
            {0, 2},
            {0, 1},
        };
        topo(graph);
    }
}
