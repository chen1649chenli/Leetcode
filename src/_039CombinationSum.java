import java.util.ArrayList;
import java.util.List;

public class _039CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        backtrack(ans, candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int[] candidates, int target, List<Integer> list, int start){
        if (sumAll(list) == target){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++){
            if (sumAll(list) + candidates[i] <= target){
                list.add(candidates[i]);
                backtrack(ans, candidates, target, list, i + 1);
                list.remove(list.size() - 1);
            }else{
                continue;
            }
        }
    }

    private int sumAll(List<Integer> list){
        int sum = 0;
        for (int i : list){
            sum += i;
        }
        return sum;
    }
}
