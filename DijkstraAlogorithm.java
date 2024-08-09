package GRAPHS;
import java.util.*;
public class DijkstraAlogorithm {
    public static class Edge{
        int source;
        int destination;
        int weight;
        Edge(int source,int destination,int weight){
            this.source=source;
            this.destination=destination;
            this.weight=weight;
        }
    }
    public static void diskatra(List<Edge>[]edge,int source){
        int v=edge.length;
        int[]dist=new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source,0});
        while (!pq.isEmpty()) {
            int[] curr=pq.remove();
            int current=curr[0];
            int dis=curr[1];
            for(Edge edges:edge[current]){
                int neighbour=edges.destination;
                int weight=edges.weight;
                if (dis+ weight < dist[neighbour]) {
                    dist[neighbour] = dis+ weight;
                    pq.add(new int[]{neighbour, dist[neighbour]});
                }
            }
        } for (int i = 0; i < v; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }public static void main(String[] args) {
        int V = 5;
        List<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 4, 3));
        graph[1].add(new Edge(1, 2, 2));
        graph[1].add(new Edge(1, 4, 4));
        graph[2].add(new Edge(2, 3, 9));
        graph[3].add(new Edge(3, 2, 7));
        graph[4].add(new Edge(4, 1, 1));
        graph[4].add(new Edge(4, 2, 8));
        graph[4].add(new Edge(4, 3, 2));
        diskatra(graph, 0);
    }
}
