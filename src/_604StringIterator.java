import java.util.LinkedList;
import java.util.Queue;

public class _604StringIterator {
    Queue<int[]> q;
    public _604StringIterator(String compressedString) {
        q = new LinkedList<>();
        for (int i = 0; i < compressedString.length();){
            int _1 = compressedString.charAt(i) - 'A';
            int j = i + 1;
            while(j < compressedString.length() && compressedString.charAt(j) < 'A'){
                j += 1;
            }
            int _2 = Integer.parseInt(compressedString.substring(i+1, j));
            q.add(new int[]{_1, _2});
            i = j;
        }
    }

    public char next() {
        if (q.isEmpty()) return ' ';
        int[] node = q.peek();
        if (node[1] == 1){
            return (char)(q.poll()[0] + 'A');
        }else{
            node[1] -= 1;
            return (char)(node[0] + 'A');
        }
    }

    public boolean hasNext() {
        return q.size() > 0;
    }
}
