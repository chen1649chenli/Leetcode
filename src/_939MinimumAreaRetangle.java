import java.util.HashSet;
import java.util.Set;

public class _939MinimumAreaRetangle {
    public int minAreaRect(int[][] points) {
        if (points.length < 4) return 0;

        Set<String> set = new HashSet<>();
        int ans = Integer.MAX_VALUE;

        for (int[] point: points){
            set.add(point[0] + "#" + point[1]);
        }
        int len = points.length;
        for (int i = 0; i < len; i += 1){
            for (int j = i + 1; j < len; j += 1){
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) continue;
                if (set.contains(points[i][0] + "#" +points[j][1]) && set.contains(points[j][0] + "#" +points[i][1])){
                    int area = Math.abs((points[i][0] - points[j][0])*(points[i][1] - points[j][1]));
                    ans = Math.min(area, ans);
                }

            }
        }
        return ans == Integer.MAX_VALUE? 0: ans;
    }
}
