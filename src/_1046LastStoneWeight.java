import java.util.Collections;
import java.util.PriorityQueue;

public class _1046LastStoneWeight {
    PriorityQueue<Integer> pq;
    public int lastStoneWeight(int[] stones) {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones){
            pq.offer(i);
        }
        while(pq.size() > 1){
            int bigger = pq.poll();
            int big = pq.poll();
            if (bigger - big > 0) pq.offer(bigger - big);
        }
        return pq.size() == 1 ? pq.poll() : 0;
    }
}
