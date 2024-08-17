package GRAPHS;

import java.util.*;

public class MinimumMultiplicationToReachEnd {
    public static void minimum(int[]multiplier,int start,int target){
        final int mod=100000;
        Queue<Integer>q=new LinkedList<>();
        Set<Integer>set= new HashSet<>();
        q.add(start);
        set.add(start);
        int step=0;
        while (!q.isEmpty()) {
            int size=q.size();
            step++;
            for (int i = 0; i < size; i++) {
                int curr=q.remove();
                for(int mul:multiplier){
                    int newNumber= (curr*mul)%mod;
                    if(newNumber==target){
                        System.out.println(step);
                        return;
                    }if (newNumber<target && !set.contains(newNumber)) {
                        q.add(newNumber);
                        set.add(newNumber);
                    }
                }
            }
        }
    }public static void main(String[] args) {
        int[] multipliers = {2, 3, 5};
        minimum(multipliers, 3, 30);
    }
}
