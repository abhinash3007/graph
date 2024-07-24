package GRAPHS;
import java.util.*;
public class NumberOfProvinces {
    public static class Edge{
        int source;
        int destination;
        int weight;
        Edge(int source,int destination,int weight){
            this.source=source;
            this.destination=destination;
            this.weight=weight;
        }
    }public static void cretaeGraph(ArrayList<Edge>[]graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 4, 1));

        graph[6].add(new Edge(6, 7, 1));
        graph[7].add(new Edge(7, 6, 1));

    }public static void bfs(ArrayList<Edge>[]graph, boolean[]visited,int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(Edge e:graph[node]){
                if(!visited[e.destination]){
                    queue.add(e.destination);
                    visited[e.destination]=true;
                }
            }
        }
    }public static void provinces(ArrayList<Edge>[]graph){
        boolean[]visisted=new boolean[graph.length];
        int count=0;
        for (int i = 0; i < graph.length; i++) {
            if(!visisted[i]){
                bfs(graph,visisted,i);
                count++;
            }
        }System.out.println("total"+" "+ count);
    }
    public static void main(String[] args) {
        int vertices=8;
        ArrayList<Edge>[]graph=new ArrayList[vertices];
        cretaeGraph(graph);
        for (int i = 0; i < graph.length; i++) {
            for (Edge e : graph[i]) {
                System.out.println(e.destination + " " + e.weight);
            }
        }
        provinces(graph);
    }
}
