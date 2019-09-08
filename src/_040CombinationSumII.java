import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _040CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);

        backtrack(ans, candidates, target, new ArrayList<>(), 0, target);
        return ans;


    }

    private void backtrack(List<List<Integer>> ans, int[] candidates, int target, List<Integer> list, int start, int remain){
        if (remain == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i += 1){
            if (remain >= candidates[i]){
                list.add(candidates[i]);
                backtrack(ans, candidates, target, list, i+ 1, remain - candidates[i]);
                list.remove(list.size() - 1);
            }else{
                continue;
            }
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1] ){
                i += 1;
            }
        }
    }
}
