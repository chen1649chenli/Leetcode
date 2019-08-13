import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        backtrack(ans, nums, new ArrayList<>(), 0);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans, int[] nums, List<Integer> list, int start){
        ans.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++){
            if (i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            backtrack(ans, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
