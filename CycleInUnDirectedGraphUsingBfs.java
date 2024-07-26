package GRAPHS;

import java.util.*;

public class CycleInUnDirectedGraphUsingBfs {
    public static class Edge{
        int source;
        int destination;
        int weigth;
        Edge(int source,int destination,int weight){
            this.source=source;
            this.destination=destination;
            this.weigth=weight;
        }
    }public static boolean isCycle( ArrayList<Edge>[]graph){
        boolean[]visited=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                if(isCycleBfs(graph,i,visited)){
                    return true;
                }
            }
        }return false;
    }public static boolean isCycleBfs(ArrayList<Edge>[]graph,int start,boolean[]visited){
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{start,-1});
        visited[start]=true;
        while (!q.isEmpty()) {
            int[]curr=q.remove();
            int current=curr[0];
            int parent=curr[1];
            for(Edge e: graph[current]){
                int neighbour=e.destination;
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.add(new int[]{neighbour,current});
                }else if(neighbour!=parent)  {
                    return true;
                }
            }
        }return false;
    } public static void main(String[] args) {
        int vertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 0, 1));
        graph[0].add(new Edge(0, 4, 1));
        System.out.println(isCycle(graph));
    }
}
