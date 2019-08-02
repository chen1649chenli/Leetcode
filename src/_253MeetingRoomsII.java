import java.lang.reflect.Array;
import java.util.*;

public class _253MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;


        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 0;
        for (int i = 0; i < intervals.length; i++){
            if (pq.isEmpty()){
                pq.offer(intervals[i]);
            }else{
                while (pq.size() > 0 && pq.peek()[1] <= intervals[i][0]){
                    pq.poll();
                }
                pq.offer(intervals[i]);
            }
            count = Math.max(count, pq.size());
        }
        return count;
    }
}
