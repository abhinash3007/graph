package GRAPHS;

public class FindEvantualSafeState {
    public static void isSafe(int[][]graph){
        boolean[]visited=new boolean[graph.length];
        boolean[]pathVisisted=new boolean[graph.length];
        boolean[]safe=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(graph,i,visited,pathVisisted,safe);
            }
        }for (int i = 0; i < safe.length; i++) {
            if (safe[i]==true) {
                System.out.println(i+" ");
            }
        }
    }public static boolean dfs(int[][]graph,int start,boolean[]visited,boolean[]pathVisisted,boolean[]safe){
        visited[start]=true;
        pathVisisted[start]=true;
        for(int neighbor:graph[start]){
            if(!visited[neighbor]){
                if(dfs(graph, neighbor, visited, pathVisisted,safe)){
                    return true;
                }
            }else if(pathVisisted[neighbor]==true){
                return true;
            }
        }pathVisisted[start]=false;
        safe[start]=true;
        return false;
    }public static void main(String[] args) {
        int[][] graph1 = {
            {1, 2},
            {2, 3},
            {5},
            {0},
            {5},
            {},
            {}
        };

        int[][] graph2 = {
            {1, 2, 3, 4},
            {1, 2},
            {3, 4},
            {0, 4},
            {}
        };
        isSafe(graph2);
        isSafe(graph1);
    }
}
