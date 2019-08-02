import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _056MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;

        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });
        int[] newInterval = intervals[0];
        ans.add(newInterval);
        for (int[] interval : intervals){
            if (interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }else{
                newInterval = interval;
                ans.add(newInterval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
