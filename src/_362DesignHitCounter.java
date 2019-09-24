import java.util.LinkedList;
import java.util.Queue;

public class _362DesignHitCounter {
    int[] hitCount;
    int[] times;

    /** Initialize your data structure here. */
    public _362DesignHitCounter() {
        hitCount = new int[300];
        times = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int idx = timestamp % 300;
        if (times[idx] != timestamp){
            hitCount[idx] = 1;
            times[idx] = timestamp;
        }else{
            hitCount[idx] += 1;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        int cutoff = timestamp - 300;
        for (int i = 0; i < 300; i += 1){
            if (times[i] > cutoff){
                total += hitCount[i];
            }
        }
        return total;
    }
}
