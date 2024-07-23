package GRAPHS;
import java.util.*;
public class DFSInGraph {
    public static class Edge{
        int source;
        int destination;
        int weigth;
        Edge(int source,int destinatoin,int weigth){
            this.source=source;
            this.destination=destinatoin;
            this.weigth=weigth;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

    }
    public static void dfs(ArrayList<Edge>[]graph,int start, boolean[]visited){
        visited[start]=true;
        System.out.println(start+" ");

        for (Edge e:graph[start]) {
            if(!visited[e.destination]){
                dfs(graph,e.destination,visited);
            }
        }
    }public static void main(String[] args) {
        int vertices=7;
        boolean[] visited = new boolean[vertices];
        ArrayList<Edge>[]graph=new ArrayList[vertices];
        createGraph(graph);
        dfs(graph, 0, visited);
    }
}
