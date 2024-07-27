package GRAPHS;

public class SurroundedRegionsReplaceOWithX{
    public static void surrounded(char[][]graph){
        int row=graph.length;
        int col=graph[0].length;
        boolean[][]visited=new boolean[row][col];
        for (int i = 0; i < row; i++) {
            dfs(graph,i,0);
            dfs(graph,i,col-1);
        }for(int j=0;j<col;j++){
            dfs(graph,0,j);
            dfs(graph,row-1,j);
        }for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(graph[i][j]=='O'){
                    graph[i][j]='X';
                }else if (graph[i][j] == 'T') {
                    graph[i][j] = 'O';
                }
            }
        }
    }public static void dfs(char[][]graph,int row,int col){
        if(row<0 || row>=graph.length || col<0 && col>=graph[0].length || graph[row][col]=='X'){
            return;
        }graph[row][col]='T';
        dfs(graph, row-1, col);
        dfs(graph, row, col+1);
        dfs(graph, row+1, col);
        dfs(graph, row, col-1);
    }public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };surrounded(board);
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
