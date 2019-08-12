import java.util.*;

public class _078Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        Arrays.sort(nums);
        backtrack(list, nums, new ArrayList<>(), 0 );
        return list;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, List<Integer> tempList, int start){
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, nums, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
