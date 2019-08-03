import java.util.Collections;
import java.util.PriorityQueue;

public class _011ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = Integer.MIN_VALUE;
        int i = 0, j = height.length - 1;
        while(i < j){
            res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]){
                i += 1;
            }else {
                j -= 1;
            }
        }
        return res;
    }
}
