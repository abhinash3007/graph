package GRAPHS;

import java.util.Arrays;
import java.util.Comparator;

public class KruskalsAlgorithm {
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

    static int[] parent;
    static int[] rank;

    // Find method with path compression
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    // Union method with union by rank
    public static void union(int x, int y) {
        int parX = find(x);
        int parY = find(y);

        if (parX != parY) {
            // Union by rank
            if (rank[parX] > rank[parY]) {
                parent[parY] = parX;
            } else if (rank[parX] < rank[parY]) {
                parent[parX] = parY;
            } else {
                parent[parY] = parX;
                rank[parX]++;
            }
        }
    }

    // Kruskal's algorithm to find the MST
    public static void kruskal(Edge[] edges, int size) {
        // Initialize the Disjoint Set directly
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // Sort the edges by weight
        Arrays.sort(edges, Comparator.comparingInt(edge -> edge.weight));

        int totalWeight = 0;
        for (Edge edge : edges) {
            int rootSource = find(edge.source);
            int rootDestination = find(edge.destination);

            // If the edge does not form a cycle, include it in the MST
            if (rootSource != rootDestination) {
                union(rootSource, rootDestination);
                totalWeight += edge.weight;
                System.out.println("Edge included: (" + edge.source + ", " + edge.destination + ") with weight " + edge.weight);
            }
        }
        System.out.println("Total weight of Minimum Spanning Tree: " + totalWeight);
    }

    public static void main(String[] args) {
        Edge[] edges = {
            new Edge(0, 1, 10),
            new Edge(0, 2, 6),
            new Edge(0, 3, 5),
            new Edge(1, 3, 15),
            new Edge(2, 3, 4)
        };

        int size = 4; // Number of vertices
        kruskal(edges, size);
    }
}
