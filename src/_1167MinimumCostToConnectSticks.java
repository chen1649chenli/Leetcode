import java.util.PriorityQueue;

public class _1167MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick: sticks){
            pq.offer(stick);
        }

        int cost = 0;
        if (pq.size() == 1){
            cost = 0;
        }else{
            while(pq.size() > 1){
                int stick1 = pq.poll();
                int stick2 = pq.poll();
                cost += stick1 + stick2;
                pq.offer(stick1 + stick2);
            }
        }
        return cost;
    }
}
