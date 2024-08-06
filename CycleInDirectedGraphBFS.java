package GRAPHS;

import java.util.*;

public class CycleInDirectedGraphBFS {
    public static boolean isCycle(int[][]graph){
        int[]inDegree=new int[graph.length];
        Queue<Integer>q=new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            for(int neighbour:graph[i]){
                inDegree[neighbour]++;
            }
        }for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i]==0){
                q.add(i);
            }
        }int count=0;
        while (!q.isEmpty()) {
            int curr=q.remove();
            count++;
            for(int neighbor:graph[curr]){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }return count!=graph.length;
    }public static void main(String[] args) {
        int[][] graph1 = {
            {1},
            {2},
            {0, 3},
            {4},
            {}
        };

        int[][] graph2 = {
            {1, 2},
            {2},
            {3},
            {4},
            {}
        };
        System.out.println(isCycle(graph2));
        System.out.println(isCycle(graph1));
    }
}
