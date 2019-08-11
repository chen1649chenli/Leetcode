import java.util.ArrayList;
import java.util.List;

public class _046Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;

        helper(ans, new ArrayList<>(), nums);
        return  ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> list, int[] nums){
        if (list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(ans, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
