import java.util.Collections;
import java.util.PriorityQueue;

public class _011ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i += 1){
            for (int j = i + 1; j < height.length; j += 1){
                int tmp = (j - i) * Math.min(height[i], height[j]);
                res = Math.max(tmp, res);
            }
        }
        return res;
    }
}
