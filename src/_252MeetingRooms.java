import java.util.Arrays;
import java.util.Comparator;

public class _252MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < intervals.length -1; i += 1){
            if (intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }
}
