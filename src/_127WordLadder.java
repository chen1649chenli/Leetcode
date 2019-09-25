import java.util.*;

public class _127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        q.offer(null);
        visited.add(beginWord);
        int step = 1;
        if (!dict.contains(endWord)) return 0;

        while(q.size() > 1){
            String str = q.poll();
            if (str == null){
                q.offer(null);
                step += 1;
                continue;
            }
            for (int i = 0; i < str.length(); i += 1){
                char[] chars = str.toCharArray();
                for (char c = 'a'; c <= 'z'; c += 1){
                    chars[i] = c;
                    String word = new String(chars);
                    if (word.equals(endWord)){
                        return step + 1;
                    }
                    if (dict.contains(word) && !visited.contains(word)){
                        q.offer(word);
                        visited.add(word);
                    }
                }
            }
        }
        return 0;
    }
}
