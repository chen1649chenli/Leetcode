import java.util.*;

public class _763PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer>ansList = new ArrayList<>();
        if (S == null || S.length() == 0) return ansList;

        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < S.length(); i += 1){
            if (!map.containsKey(S.charAt(i))){
                map.put(S.charAt(i), new int[]{i, i});
            }else{
                int[] tmp = map.get(S.charAt(i));
                tmp[1] = i;
                map.put(S.charAt(i), tmp);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (char c: map.keySet()){
            pq.add(map.get(c));
        }

        int[] prev = pq.poll();

        while(pq.size() > 0){
            int[] curr = pq.poll();
            if (curr[0] < prev[1]){
                prev[1] = Math.max(prev[1], curr[1]);
            }else{
                ansList.add(prev[1] - prev[0] + 1);
                prev = curr;
            }
        }
        ansList.add(prev[1] - prev[0] + 1);
        return ansList;
    }
}
