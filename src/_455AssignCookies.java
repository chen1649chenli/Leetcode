import java.util.Collections;
import java.util.PriorityQueue;

public class _455AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        PriorityQueue<Integer> greedy = new PriorityQueue<>();
        PriorityQueue<Integer> size = new PriorityQueue<>();
        for (int i: g){
            greedy.add(i);
        }
        for (int j: s){
            size.add(j);
        }
        int sum = 0;


        while(greedy.size() > 0 && size.size() > 0){
            if (greedy.peek() > size.peek()){
                size.poll();
            }else{
                greedy.poll();
                size.poll();
                sum += 1;
            }
        }
        return sum;
    }
}
