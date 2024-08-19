package GRAPHS;

import java.util.Arrays;

public class BellmonFordAlgorithm {
    public static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void bellman(Edge[] edge, int v, int src) {
        int[] dis = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        for (int i = 0; i < v - 1; i++) {
            for (Edge e : edge) {
                int currSrc = e.source;
                int currDes = e.destination;
                int currWeight = e.weight;
                if (dis[currSrc] != Integer.MAX_VALUE && dis[currDes] + currWeight < dis[currDes]) {
                    dis[currDes] = dis[currSrc] + currWeight;
                }
            }
        }
        for (Edge e : edge) {
            int currSrc = e.source;
            int currDes = e.destination;
            int currWeight = e.weight;
            if (dis[currSrc] != Integer.MAX_VALUE && dis[currDes] + currWeight < dis[currDes]) {
                System.out.println("Graph contains cycle");
                return;
            }
        }for(int i=0;i<v;i++){
            System.out.println(dis[i]+" ");
        }
    }public static void main(String[] args) {
        Edge[] edges = new Edge[8];
        edges[0] = new Edge(0, 1, -1);
        edges[1] = new Edge(0, 2, 4);
        edges[2] = new Edge(1, 2, 3);
        edges[3] = new Edge(1, 3, 2);
        edges[4] = new Edge(1, 4, 2);
        edges[5] = new Edge(3, 2, 5);
        edges[6] = new Edge(3, 1, 1);
        edges[7] = new Edge(4, 3, -3);
        bellman(edges, 5, 0 );
    }
}
