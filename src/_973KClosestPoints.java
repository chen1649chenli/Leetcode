import java.util.Comparator;
import java.util.PriorityQueue;

public class _973KClosestPoints {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1];
            }
        });
        for (int[] point: points){
            pq.add(point);
        }
        for(int i = 0; i < K; i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}
