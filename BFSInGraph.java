package GRAPHS;

import java.util.*;

public class BFSInGraph {
    public static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weigth) {
            this.source = source;
            this.destination = destination;
            this.weight = weigth;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
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

    public static void bfs(ArrayList<Edge>[] graph, int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visisted = new boolean[graph.length];

        q.add(start);
        visisted[start] = true;
        System.out.println(start);

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.println(curr);

            for (Edge e : graph[curr]) {
                if (!visisted[e.destination]) {
                    q.add(e.destination);
                    visisted[e.destination] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);
        // for (int i = 0; i < graph.length; i++) {
        //     System.out.println(i + " ");
        //     for (Edge e : graph[i]) {
        //         System.out.println(e.destination + " " + e.weight);
        //     }
        // }
        bfs(graph,0);
    }
}
