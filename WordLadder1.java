package GRAPHS;

import java.util.*;

public class WordLadder1 {
    public static void ladder(String startWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(startWord);
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            // depth++;
            for (int i = 0; i < size; i++) {
                String curr = q.remove();
                char[] currentChar = curr.toCharArray();
                for (int j = 0; j < currentChar.length; j++) {
                    char original = currentChar[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        currentChar[j] = ch;
                        String newWord = new String(currentChar);
                        if (newWord.equals(endWord)) {
                            System.out.println(depth + 1);
                        }
                        if (wordSet.contains(newWord)) {
                            q.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    currentChar[j] = original;
                }
            }
            depth++;
        }
        System.out.println(0);
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        ladder(beginWord, endWord, wordList); // Output: 5
    }
}
