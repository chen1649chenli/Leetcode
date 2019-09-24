import java.util.LinkedList;
import java.util.Queue;

public class _362DesignHitCounter {
    Queue<Integer> q;

    /** Initialize your data structure here. */
    public _362DesignHitCounter() {
        q = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {

        while(!q.isEmpty() && q.peek() <= timestamp - 300){
            q.poll();
        }
        return q.size();
    }
}
