import java.util.Map;
import java.util.PriorityQueue;

public class AmazonOA_LongestStringWithout3ConsecutiveCharacters {
    public String generateString(Map<Character, Integer> map){
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) ->(b.getValue() -a.getValue()));
        int count = 0;
        for (Map.Entry<Character, Integer> item : map.entrySet()){
            count += item.getValue();
            pq.add(item);
        }

        StringBuilder sb = new StringBuilder();
        Map.Entry<Character, Integer> onHold = null;
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> curr = pq.poll();
            sb.append(curr.getKey());
            if (curr.getValue() > 1){
                curr.setValue(curr.getValue() - 1);
            }
            if(onHold != null){
                pq.add(onHold);
                onHold = null;
            }

            if (sb.length() >=2 && sb.charAt(sb.length() -1) ==curr.getValue() && sb.charAt(sb.length() - 2) ==curr.getValue()){
                onHold = curr;
            }else{
                pq.add(curr);
            }
        }
        return sb.toString();
    }
}
