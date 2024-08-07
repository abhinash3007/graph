package GRAPHS;

import java.util.*;

public class FindEvantualSafeBFS {
    public static void safe(int[][]graph){
        int[]indegree=new int[graph.length];
        List<Integer>[]reverse=new ArrayList[graph.length];
        Queue<Integer>q=new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            reverse[i] = new ArrayList<>();
        }
        for(int i=0;i<graph.length;i++){
            for(int neighbour:graph[i]){
                reverse[neighbour].add(i);
                indegree[i]++;
            }
        }for(int i=0;i<graph.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }while (!q.isEmpty()) {
            int curr=q.remove();
            System.out.println(curr);
            for(int neighbor:reverse[curr]){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }
    }public static void main(String[] args) {
        int[][] graph = {
            {1, 2}, 
            {2, 3}, 
            {5}, 
            {0}, 
            {5}, 
            {}, 
            {} 
        };safe(graph);
    }
}
