package GRAPHS;

public class DisJointSet {
    public int[] rank;
    public int[] parent;

    public DisJointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if(x==parent[x]){
            return x;
        }parent[x]=find(parent[x]);
        return parent[x];
    }

    // Union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
    }

    public static void main(String[] args) {
        DisJointSet ds = new DisJointSet(5);
        
        ds.union(1, 2);
        ds.union(3, 4);
        ds.union(1, 4);
        
        System.out.println("Find(4): " + ds.find(4));
        System.out.println("Find(1): " + ds.find(1));
        
    }
}
