package GRAPHS;

public class ImplementationUsingMatrix {
    public static void addEdge(int[][]graph,int source,int destination,int weight){
        graph[source][destination]=weight;
    }public static void printGraph(int[][]graph){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j]+" ");
            }System.out.println();
        }
    }public static void main(String[] args) {
        int vertices=5;
        int[][]graph=new int[vertices][vertices];

        addEdge(graph, 0, 1, 1);
        addEdge(graph, 1, 2, 1);
        addEdge(graph, 1, 3, 1);
        addEdge(graph, 2, 3, 1);
        addEdge(graph, 3, 1, 1);

        // Print the graph to verify
        printGraph(graph);
    }
}
