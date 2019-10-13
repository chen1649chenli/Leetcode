import java.util.*;

public class _269AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        if (words.length == 1) return words[0];

        Map<Integer, Integer> degree = new HashMap<>();
        Set<Integer>[] graph = new Set[26];
        StringBuilder sb = new StringBuilder();
        for (String word: words){
            for (char c: word.toCharArray()){
                degree.put(c-'a',0);
            }
        }

        for (int i = 0; i < words.length - 1; i += 1){
            String curr = words[i];
            String next = words[i + 1];
            int len = Math.min(curr.length(), next.length());
            for (int j = 0; j < len; j += 1){
                if (curr.charAt(j) != next.charAt(j)){
                    char ch1 = curr.charAt(j);
                    char ch2 = next.charAt(j);

                    if (graph[ch1 - 'a'] == null){
                        graph[ch1 - 'a'] = new HashSet<>();
                    }

                    if (!graph[ch1 - 'a'].contains(ch2 - 'a')){
                        graph[ch1 - 'a'].add(ch2 - 'a');
                        degree.put(ch2 - 'a', degree.get(ch2 - 'a') + 1);
                    }
                    break;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int node: degree.keySet()){
            if (degree.get(node) == 0){
                q.offer(node);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            sb.append((char)('a' + node));
            Set<Integer> connected = graph[node];
            if (connected == null) continue;
            for (int post: connected){
                int nextDegree = degree.get(post) - 1;
                if (nextDegree == 0){
                    q.offer(post);
                }
                degree.put(post, nextDegree);
            }
        }
        if (sb.length() != degree.size()) return "";
        return sb.toString();
    }
}
