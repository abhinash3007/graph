package GRAPHS;

import java.util.*;

public class AlienDictionary {
    public static void alien(String[] words) {
        int[][] graph = new int[26][26];
        int[] present = new int[26];
        int[] inDegree = new int[26];

        // Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    int idx1 = c1 - 'a';
                    int idx2 = c2 - 'a';
                    if (graph[idx1][idx2] == 0) {
                        graph[idx1][idx2] = 1;
                        inDegree[idx2]++;
                    }
                    break;
                }
            }
        }

        // Mark characters present in words
        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = 1;
            }
        }

        // Initialize the queue with nodes having 0 in-degree
        Queue<Integer> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0 && present[i] == 1) {
                q.add(i);
            }
        }

        // Perform BFS for topological sorting
        while (!q.isEmpty()) {
            int curr = q.remove();
            str.append((char) (curr + 'a'));
            for (int i = 0; i < 26; i++) {
                if (graph[curr][i] == 1) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }

        // Check if topological sort included all characters
        for (int i = 0; i < 26; i++) {
            if (present[i] == 1 && inDegree[i] > 0) {
                System.out.println("[]");
                return;
            }
        }

        System.out.println(str.toString());
    }

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        alien(words);
    }
}
