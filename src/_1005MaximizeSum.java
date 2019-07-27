import java.util.PriorityQueue;

public class _1005MaximizeSum {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for (int i : A){
            pq.add(i);
            sum += i;
        }
        while(K-- > 0){
            int num = pq.poll();
            sum = sum - 2 * num;
            pq.add(-num);
        }
        return sum;
    }
}
