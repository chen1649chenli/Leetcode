import java.util.PriorityQueue;

public class _703KthLargestElement {
    private PriorityQueue<Integer> pq;
    final int k;
    public _703KthLargestElement(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        this.k = k;
        for (int i : nums){
            add(i);
        }
    }

    public int add(int val) {

        if (pq.size() < k){
            pq.add(val);
        }else if(val > pq.peek()){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
