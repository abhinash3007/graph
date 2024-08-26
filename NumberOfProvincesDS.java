package GRAPHS;

public class NumberOfProvincesDS {
    public static class Edge{
        int source;
        int destination;
        int weight;
        Edge(int source,int destination,int weight){
            this.source=source;
            this.destination=destination;
            this.weight=weight;
        }
    }static int[]rank;
    static int[]parent;
    public static int find(int x){
        if(parent[x]==x){
            return x;
        }parent[x]=find(parent[x]);
        return parent[x];
    }public static void union(int x,int y){
        int parX=find(x);
        int parY=find(y);
        if(parX!=parY){
            if(rank[parX]>rank[parY]){
                parent[parY]=parX;
            }if(rank[parY]>rank[parX]){
                parent[parX]=parY;
            }else{
                parent[parY]=parX;
                rank[parX]++;
            }
        }
    }public static void provinces(int[][]graph,int size){
        parent=new int[size];
        rank=new int[size];
        for (int i = 0; i < size; i++) {
            parent[i]=i;
            rank[i]=0;
        }for (int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j]==1){
                    union(i, j);
                }
            }
        }int province=0;
        for(int i = 0; i < size; i++){
            if (find(i)==i) {
                province++;
            }
        }System.out.println(province);
    }public static void main(String[] args) {
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        provinces(isConnected, 3);
    }
}
