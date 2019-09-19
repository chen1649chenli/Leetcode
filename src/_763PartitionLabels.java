import java.util.*;

public class _763PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer>ansList = new ArrayList<>();
        if (S == null || S.length() == 0) return ansList;
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i += 1){
            last[S.charAt(i) - 'a'] = i;
        }
        int start = -1, end = -1;
        for (int i = 0; i < S.length(); i += 1){
            if (start == -1){
                start = i;
            }
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (end == i){
                ansList.add(end - start + 1);
                start = -1;
            }
        }
        return ansList;
    }
}
