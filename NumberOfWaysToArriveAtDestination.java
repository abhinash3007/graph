package GRAPHS;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {

    public static void total(int[][]roads,int n){
        List<List<int[]>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }for(int[]road:roads){
            graph.get(road[0]).add(new int[]{road[1],road[2]});
            graph.get(road[1]).add(new int[]{road[0],road[2]});
        }int[]dis=new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0]=0;
        int[]way=new int[n];
        way[0]=1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x->x[1]));
        pq.add(new int[]{0,0});
        while (!pq.isEmpty()) {
            int[]current=pq.remove();
            int destination=current[0];
            int weight=current[1];
            for(int[]neighbour:graph.get(destination)){
                int next=neighbour[0];
                int time=neighbour[1];
                if(weight+time<dis[next]){
                    dis[next]=weight+time;
                    way[next]=way[destination];
                    pq.add(new int[]{next,dis[next]});
                }else if (dis[destination] + time == dis[next]) {
                        way[next] += way[destination];   
                }
            }
        }System.out.println(way[n-1]);
    }public static void main(String[] args) {
        int[][] roads = {
            {0, 1, 4},
            {0, 2, 3},
            {1, 2, 1},
            {1, 3, 2},
            {2, 3, 4}
        };
        total(roads, 4);
    }
}
