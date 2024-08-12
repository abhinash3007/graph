package GRAPHS;

import java.util.*;

public class CheapestFlightWithKstop {
    public static class Flight{
        int to;
        int cost;
        int stop;
        Flight(int to,int cost,int stop){
            this.to=to;
            this.cost=cost;
            this.stop=stop;
        }
    }public static void cheap(int n,int[][]flights,int src,int des,int k){
        int[][]graph=new int[n][n];
        int[][]dist=new int[n][n];
        for(int[]flight:flights){
            graph[flight[0]][flight[1]]=flight[2];
        } PriorityQueue<Flight> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new Flight(src, 0, 0));
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[src][0] = 0;
        while (!pq.isEmpty()) {
            Flight curr=pq.remove();
            if(curr.to==des){
                System.out.println(curr.cost+1);
                return;
            }
            if (curr.stop > k) {
                continue;
            }
        }
    }
}
