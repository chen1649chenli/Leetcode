import java.util.PriorityQueue;

public class _215KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums){
            if (pq.size() < k){
                pq.offer(num);
            }else{
                int low = pq.peek();
                if (num > low){
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        return pq.poll();
    }
}
