package GRAPHS;

public class FloydWarshallAlgorithm {
    public static void floyd(int[][]graph){
        int[][]dis=new int[graph.length][graph[0].length];
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                if(i==j){
                    dis[i][j]=0;
                }else if(graph[i][j]!=0){
                    dis[i][j]=graph[i][j];
                }else{
                    dis[i][j]=Integer.MAX_VALUE;
                }
            }
        }for(int via=0;via<graph.length;via++){
            for (int i = 0; i < graph.length; i++) {
                for(int j=0; j<graph[0].length; j++){
                    if(dis[i][via]!=Integer.MAX_VALUE && dis[via][j]!=Integer.MAX_VALUE){
                        dis[i][j]=Math.min(dis[i][j], dis[i][via] + dis[via][j]);
                    }
                }
            }
        }for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                if(dis[i][i]<0){
                    System.out.println("graph has cycle");
                }
            }
        }for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                if (dis[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dis[i][j] + " ");
                }
            }
            System.out.println();
        }
    }public static void main(String[] args) {
        int[][] graph = {
            {0, 3, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {2, 0, Integer.MAX_VALUE, 1},
            {Integer.MAX_VALUE, 7, 0, 2},
            {6, Integer.MAX_VALUE, 8, 0}
        };
        floyd(graph);
    }
}
