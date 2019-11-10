import java.util.Map;
import java.util.HashMap;

public class _001TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> dict = new HashMap<>();
        int size = nums.length;
        for (int i = 0; i < size; i += 1){
            if (dict.containsKey(target - nums[i])){
                ans[0] = dict.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }else{
                dict.put(nums[i], i);
            }
        }
        return ans;
    }
}