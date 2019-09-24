import java.util.PriorityQueue;
import java.util.Queue;

public class _295FindMedianFromDataStream {
    Queue<Long> small;
    Queue<Long> big;
    int size;
    long sum;
    int min;
    int max;

    /** initialize your data structure here. */
    public _295FindMedianFromDataStream() {
        small = new PriorityQueue<>();
        big = new PriorityQueue<>();
        size = 0;
        sum = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    public void addNum(int num) {
        this.size += 1;
        this.sum += num;
        this.min = Math.min(this.min, num);
        this.max = Math.max(this.max, num);
        big.offer((long) num);
        small.offer(-big.poll());
        if (small.size() > big.size()){
            big.offer(-small.poll());
        }
    }

    public double findMedian() {
        if (big.size() > small.size()){
            return big.peek() * 1.0;
        }else{
            return (big.peek() - small.peek())/2.0;
        }
    }

    public int findMin(){
        return this.min;
    }

    public int findMax(){
        return this.max;
    }

    public double findAvg(){
        return this.sum * 1.0 / this.size;
    }
}
