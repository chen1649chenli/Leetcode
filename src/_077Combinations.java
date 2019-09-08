import java.util.ArrayList;
import java.util.List;

public class _077Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n < k || n < 1) return ans;

        backtrack(ans, new ArrayList<>(), n, k, 1);

        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> list, int n, int k, int start){
        if (list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <=n ; i += 1){
            list.add(i);
            backtrack(ans, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
