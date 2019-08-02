import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _435NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]){
                    return o1[1] - o2[1];
                }else{
                    return o2[0] - o1[0];
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        int[] newIntervals = intervals[0];
        ans.add(newIntervals);
        for (int[] interval: intervals){
            if (interval[0] >= newIntervals[1] || interval[1] <= newIntervals[0]){
                newIntervals = interval;
                ans.add(newIntervals);
            }else{
                continue;
            }
        }
        return intervals.length - ans.size();
    }
}
