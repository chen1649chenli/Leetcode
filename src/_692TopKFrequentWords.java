import java.util.*;
public class _692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new LinkedList<>();
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word: words){
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() != o2.getValue()){
                    return o1.getValue() - o2.getValue();
                }else{
                    return -o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        for (Map.Entry<String, Integer> entry: frequencyMap.entrySet()){
            pq.offer(entry);
            if (pq.size() > k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            ans.add(pq.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
    }
}
