import java.util.*;

public class _347TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new LinkedList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<HashMap.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<HashMap.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> pair: count.entrySet()){
            pq.offer(pair);
        }
        for (int i = 0; i < k; i ++){
            ans.add(pq.poll().getKey());
        }
        return ans;
    }
}
