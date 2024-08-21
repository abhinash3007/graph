package GRAPHS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static class Edge {
        int weight;
        int destination;

        Edge(int weight, int destination) {
            this.weight = weight;
            this.destination = destination;
        }
    }

    public static void minimum(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        pq.add(new Edge(0, 0));
        int total = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            int currWei = curr.weight;
            int currSrc = curr.destination;
            if (visited[currSrc])
                continue;
            visited[currSrc] = true;
             total += currWei;
            for (int i = 0; i < graph.length; i++) {
                if (graph[currSrc][i] != 0 && !visited[i]) {
                    pq.add(new Edge(graph[currSrc][i], i));
                }
            }
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
        };

        minimum(graph);
    }
}
