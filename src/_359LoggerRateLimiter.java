import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _359LoggerRateLimiter {
    int[] timeBucket;
    Set<String>[] messageSets;

    public _359LoggerRateLimiter () {
        timeBucket = new int[10];
        messageSets = new Set[10];
        for (int i = 0; i < messageSets.length; i += 1){
            messageSets[i] = new HashSet<>();
        }
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        int idx = timestamp % 10;
        if (timeBucket[idx] != timestamp){
            messageSets[idx].clear();
            timeBucket[idx] = timestamp;

        }
        for (int i = 0; i < messageSets.length; i += 1){
            if (timestamp - timeBucket[i] < 10){
                if (messageSets[i].contains(message)){
                    return false;
                }
            }
        }
        messageSets[idx].add(message);
        return true;
    }
}
