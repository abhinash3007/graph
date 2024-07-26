package GRAPHS;
import java.util.*;
public class CycleInUnDirectedGraphUsingDfs {
    public static class Edge{
        int source;
        int destination;
        int weigth;
        Edge(int source,int destination,int weight){
            this.source=source;
            this.destination=destination;
            this.weigth=weight;
        }
    }public static boolean isCycle(ArrayList<Edge>[]graph){
        boolean[]visited=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                if(dfsCycle(graph,i,visited,-1)){
                    return true;
                }
            }
        }return false;
    }public static boolean dfsCycle(ArrayList<Edge>[]graph,int start,boolean[] visited,int parent){
        visited[start]=true;
        for(Edge e:graph[start]){
            int neighbour=e.destination;
            if(!visited[neighbour]){
                dfsCycle(graph, neighbour, visited,start);
                return true;
            }else if(neighbour!=parent){
                return true;
            }
        }return false;
    }public static void main(String[] args) {
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
