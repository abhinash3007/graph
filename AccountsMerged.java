package GRAPHS;

import java.util.*;

public class AccountsMerged {
    static int[] parent;
    static int[] rank;

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int parX = find(x);
        int parY = find(y);
        if (parX != parY) {
            if (rank[parX] > rank[parY]) {
                parent[parY] = parX;
            } else if (rank[parY] > rank[parX]) {
                parent[parX] = parY;
            } else {
                parent[parY] = parX;
                rank[parX]++;
            }
        }
    }public void merger(List<List<String>>account){
        HashMap<String,Integer>map=new HashMap<>();
        for(int i=0;i<account.size();i++){
            for(int j=1;j<account.get(i).size();j++){
                String mail=account.get(i).get(j);
                if (!map.containsKey(j)) {
                    map.put(mail,i);
                }else{
                    union(i, map.get(mail));
                }
            }
        }
    }
}