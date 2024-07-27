package GRAPHS;

import java.util.*;
public class DistanceOfNearestCellHaving1 {
    public static class Edge{
        int source;
        int destinatoin;
        int weight;
        Edge(int source,int destination,int weight){
            this.source=source;
            this.destinatoin=destination;
            this.weight=weight;
        }
    }public static void distance(int[][]graph){
        int row=graph.length;
        int col=graph[0].length;
        Queue<int[]>q=new LinkedList<>();
        boolean[][]visited=new boolean[row][col];
        int[][]dis=new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j< col; j++) {
                if(graph[i][j]==1){
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                    dis[i][j]=0;
                }
            }
        }int[]rowD={-1,0,0,1};
        int[]colD={0,-1,1,0};
        while(!q.isEmpty()){
            int[]curr=q.remove();
            int currR=curr[0];
            int currC=curr[1];
            for(int k=0;k<4;k++){
                int newR=currR+rowD[k];
                int newC=currC+colD[k];
                if(newR>=0 && newR<row && newC>=0 && newC<col && !visited[newR][newC] && graph[newR][newC]==0){
                    dis[newR][newC]=dis[currR][currC] + 1;
                    visited[newR][newC]=true;
                    q.add(new int[]{newR,newC});
                }
            }
        }for(int i=0;i<dis.length;i++){
            for(int j=0;j<dis[0].length;j++){
                System.out.print(dis[i][j]+" ");
            }System.out.println();
        }
    }public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 1},
            {0, 0, 0},
            {0, 1, 0}
        };distance(grid);
    }
}
