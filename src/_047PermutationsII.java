import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _047PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        int size = nums.length;
        Arrays.sort(nums);

        helper(ans, nums, new ArrayList<>(), new boolean[size]);
        return ans;
    }

    private void helper(List<List<Integer>> ans, int[] nums, List<Integer> list, boolean[] visited){
        if (list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1])) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(ans, nums, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
