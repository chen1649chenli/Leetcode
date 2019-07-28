import java.util.*;

public class _1065IndexPairsOfAString {
    public int[][] indexPairs(String text, String[] words) {
        PriorityQueue<int[]> ans = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });

        for (int i = 0; i < text.length(); i++){
            for (String word: words){
                if (text.startsWith(word, i)){
                    ans.add(new int[]{i, i + word.length() - 1});
                }
            }
        }
        int size = ans.size();
        int[][] result = new int[size][2];
        for (int i = 0; i < size; i ++){
            result[i] = ans.poll();
        }
        return result;
    }
}
