import java.util.LinkedList;
import java.util.Queue;

public class _933NumberOfRecentCalls {

    Queue<Integer> q;

    public _933NumberOfRecentCalls() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        while(t - q.peek() > 3){
            q.remove();
        }
        return q.size();
    }

}
