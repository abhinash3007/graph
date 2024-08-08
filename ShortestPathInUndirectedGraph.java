package GRAPHS;

import java.util.*;

public class ShortestPathInUndirectedGraph {
    public static class Edge{
        int source;
        int destination;
        int weight;
        Edge(int source,int destination,int weight){
            this.source=source;
            this.destination=destination;
            this.weight=weight;
        }
    }public static void shortest(Edge[]edge,int vertices,int start){
        int[][]graph=new int[vertices][vertices];
        boolean[]visisted=new boolean[vertices];
        int[]dis=new int[vertices];
        for(Edge edges:edge){
            graph[edges.source][edges.destination]=1;
            graph[edges.destination][edges.source]=1;
        }
        Queue<Integer>q=new LinkedList<>();
        q.add(start);
        visisted[start]=true;
        dis[start]=0;

        while (!q.isEmpty()) {
            int curr=q.remove();
            for(int neighbour=0;neighbour<vertices;neighbour++){
                if(graph[curr][neighbour]==1 && !visisted[neighbour]){
                    q.add(neighbour);
                    visisted[neighbour]=true;
                    dis[neighbour]=dis[curr]+1;
                }
            }
        }  for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + " is at distance " + dis[i] + " from source vertex " + start);
        }
    }public static void main(String[] args) {
        Edge[] edges = new Edge[]{
            new Edge(0, 1, 1),
            new Edge(0, 3, 1),
            new Edge(1, 0, 1),
            new Edge(1, 2, 1),
            new Edge(2, 1, 1),
            new Edge(2, 6, 1),
            new Edge(3, 0, 1),
            new Edge(3, 4, 1),
            new Edge(4, 3, 1),
            new Edge(4, 5, 1),
            new Edge(5, 4, 1),
            new Edge(5, 6, 1),
            new Edge(6, 5, 1),
            new Edge(6, 7, 1),
            new Edge(6, 8, 1),
            new Edge(7, 6, 1),
            new Edge(7, 8, 1),
            new Edge(8, 7, 1),
             new Edge(8, 6, 1),
    };
    shortest(edges, 9, 0);
    }
}
