package GRAPHS;

import java.util.*;

public class CourseDetectionll {
    public static void couse(int numCourse,int[][]prerequisite){
        int[][]graph=new int[numCourse][numCourse];
        int[]inDegree=new int[graph.length];
        Queue<Integer>q=new LinkedList<>();
        for(int[]quisites:prerequisite){
            int course=quisites[0];
            int reRequired=quisites[1];
            graph[reRequired][course]=1;
            inDegree[course]++;
        }for (int i = 0; i < numCourse; i++) {
            if (inDegree[i]==0) {
                q.add(i);
            }
        }List<Integer>list=new ArrayList<>();
        while (!q.isEmpty()) {
            int curr=q.remove();
            list.add(curr);
            for (int i = 0; i < numCourse; i++) {
                if (graph[curr][i] == 1) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }if(list.size()==prerequisite.length){
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }else{
            System.out.println("[]");
        }
    }public static void main(String[] args) {
        int[][] prerequisites = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };
        couse(4,prerequisites);
    }
}
