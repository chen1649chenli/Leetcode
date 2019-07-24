import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1042FlowerPlanting {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <=N; i +=1){
            graph.put(i - 1, new HashSet<>());
        }
        for (int[] path : paths){
            graph.get(path[0] - 1).add(path[1] -1);
            graph.get(path[1] - 1).add(path[0] -1);
        }
        int[] ans = new int[N];
        for (int i = 0; i < N; i += 1){
            Set<Integer> color = new HashSet();
            for (int neighbor : graph.get(i)){
                color.add(ans[neighbor]);
            }
            for (int j = 1; j <= 4; j += 1){
                if (!color.contains(j)){
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }
}
