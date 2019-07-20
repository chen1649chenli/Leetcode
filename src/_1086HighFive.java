import java.util.*;

public class _1086HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < items.length; i += 1){
            if (!map.containsKey(items[i][0])){
                PriorityQueue<Integer> pq = new PriorityQueue<>(5);
                pq.add(items[i][1]);
                map.put(items[i][0], pq);
            } else{
                PriorityQueue<Integer> q = map.get(items[i][0]);
                if (q.size() < 5){
                    q.add(items[i][1]);
                }else if (items[i][1] > q.peek()){
                    q.poll();
                    q.add(items[i][1]);
                }
            }
        }
        int[][] ans = new int[map.size()][2];
        Set<Integer> ids =  map.keySet();
        int count = 0;
        for (int id : ids){
            int grade = helper(map.get(id));
            ans[count++] = new int[]{id, grade};
        }
        return ans;
    }

    private int helper(PriorityQueue<Integer> pq){
        int sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum / 5;
    }

}
