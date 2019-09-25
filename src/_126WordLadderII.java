import java.util.*;

public class _126WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return ans;

        Map<String, Integer> dist = new HashMap<>();
        Map<String, List<String>> adj = new HashMap<>();
        List<String> res = new ArrayList<>();

        bfs(beginWord, endWord, dict, adj, dist);
        dfs(ans, beginWord, endWord, adj, res, dist);
        return ans;
    }

    private void bfs(String beginWord, String endWord, Set<String> dict,
                     Map<String, List<String>> adj, Map<String, Integer> dist){
        dict.add(beginWord);
        Queue<String> q = new LinkedList<>();
        for (String str: dict){
            adj.put(str, new ArrayList<>());
        }
        dist.put(beginWord, 0);
        q.offer(beginWord);

        while(!q.isEmpty()){
            int count = q.size();
            boolean found = false;
            for (int i = 0; i < count; i += 1){
                String curr = q.poll();
                List<String> neighbors = getNeighbor(curr, dict);
                for (String next: neighbors){
                    adj.get(curr).add(next);
                    if (!dist.containsKey(next)){
                        dist.put(next, dist.get(curr) + 1);
                        if(next.equals(endWord)){
                            found = true;
                        }else{
                            q.offer(next);
                        }
                    }
                }
            }
            if (found) break;
        }
    }

    private List<String> getNeighbor(String curr, Set<String> dict){
        List<String> res = new ArrayList<>();
        for (int i = 0; i < curr.length(); i += 1){
            char[] chars = curr.toCharArray();
            for (char c = 'a'; c <='z'; c += 1){
                chars[i] = c;
                String word = new String(chars);
                if (!word.equals(curr) && dict.contains(word)){
                    res.add(word);
                }
            }
        }
        return res;
    }

    private void dfs(List<List<String>> ans, String curr, String end,
                     Map<String, List<String>> adj, List<String> res, Map<String, Integer> dist){
        res.add(curr);
        if (end.equals(curr)){
            ans.add(new ArrayList<>(res));
        }else{
            for(String next: adj.get(curr)){
                if(dist.get(next) == dist.get(curr) + 1){
                    dfs(ans, next, end, adj, res, dist);
                }
            }
        }
        res.remove(res.size() - 1);
    }
}
