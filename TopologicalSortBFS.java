package GRAPHS;

import java.util.*;

public class TopologicalSortBFS {
    public static void topo(int[][]graph){
        int[]indegree=new int[graph.length];
        Queue<Integer>q=new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            for(int neighbour:graph[i]){
                indegree[neighbour]++;
            }
        }for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }while (!q.isEmpty()) {
            int curr=q.remove();
            System.out.println(curr+" ");
            for(int neighbour:graph[curr]){
                indegree[neighbour]--;
                if (indegree[neighbour]==0) {
                    q.add(neighbour);
                }
            }
        }
    }public static void main(String[] args) {
        int[][]graph={
            {},
            {},
            {3},
            {1},
            {0,1},
            {0,2}
        };
        topo(graph);
    }
}
