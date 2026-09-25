import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 1. wordList ko HashSet mein convert kiya
        Set<String> set = new HashSet<>(wordList);

        // 2. Agar endWord wordList mein nahi hai
        if (!set.contains(endWord)) {
            return 0;
        }

        // 3. BFS ke liye Queue
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // beginWord ko visited maan liya
        set.remove(beginWord);

        // beginWord ki length 1 se start
        int count = 1;

        // 4. BFS
        while (!queue.isEmpty()) {

            int size = queue.size();

            // Current level ke saare words
            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                // Word ke har character ko change karo
                for (int j = 0; j < word.length(); j++) {

                    char[] arr = word.toCharArray();

                    // a se z tak character try karo
                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        arr[j] = ch;

                        String newWord = new String(arr);

                        // EndWord mil gaya
                        if (newWord.equals(endWord)) {
                            return count + 1;
                        }

                        // Dictionary mein hai
                        if (set.contains(newWord)) {
                            queue.add(newWord);

                            // visited mark
                            set.remove(newWord);
                        }
                    }
                }
            }

            // Next level
            count++;
        }

        return 0;
    }
}