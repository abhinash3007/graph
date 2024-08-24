package GRAPHS;

public class OperatoinsToMakeNetworkConnected {
    static int[] rank;
    static int[] parent;

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int x, int y) {
        int parX = find(x);
        int parY = find(y);
        if (parX != parY) {
            if (rank[parX] > rank[parY]) {
                parent[parY] = parX;
            }
            if (rank[parX] < rank[parY]) {
                parent[parX] = parY;
            } else {
                parent[parY] = parX;
                rank[parX]++;
            }
        }
    }

    public static void connectingComponent(int size, int[][] connections) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            rank[i] = 0;
            parent[i] = 1;
        }
        int extraEdges = 0;
        for (int[] connection : connections) {
            int x = find(connection[0]);
            int y = find(connection[1]);
            if (x != y) {
                union(x, y);
            } else {
                extraEdges++;
            }
        }
        int components = 0;
        for (int i = 0; i < size; i++) {
            if (find(i) == i) {
                components++;
            }
        }
        if (extraEdges >= components - 1) {
            System.out.println(components);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        int[][] connections = {
                { 0, 1 },
                { 0, 2 },
                { 0, 3 },
                { 1, 4 },
                { 1, 5 }
        };
        connectingComponent(6, connections);
    }
}
