import java.util.HashMap;
import java.util.Map;

public class _359LoggerRateLimiter {
    Map<String, Integer> log;

    public _359LoggerRateLimiter () {
        log = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!log.containsKey(message)){
            log.put(message, timestamp);
            return true;
        }else{
            int prevTimestamp = log.get(message);
            if (timestamp - prevTimestamp >= 10){
                log.put(message, timestamp);
                return true;
            }else{
                return false;
            }
        }
    }
}
