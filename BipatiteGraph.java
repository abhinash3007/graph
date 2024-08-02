package GRAPHS;

import java.lang.reflect.Array;
import java.util.*;

public class BipatiteGraph {
    public static boolean bipatite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[graph.length];
        Arrays.fill(color, 0);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                q.add(i);
                color[i] = 1;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int neighbour : graph[curr]) {
                        if (color[neighbour] == 0) {
                            color[neighbour] = -color[curr];
                            q.add(neighbour);
                        } else if (color[neighbour] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
                 {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };
        System.out.println(bipatite(graph));
    }
}
