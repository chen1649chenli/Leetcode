import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class _784LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        if (S == "" || S == null) return new ArrayList<>();

        Queue<String> queue = new LinkedList();
        queue.offer(S);

        for (int i = 0; i < S.length(); i += 1){
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j += 1){
                String s = queue.poll();
                char[] chs = s.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));

            }
        }
        return new LinkedList<>(queue);
    }
}
