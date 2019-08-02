import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _015ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i += 1){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0){
                    j += 1;
                }else if (sum > 0){
                    k -= 1;
                }else{
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j + 1]){
                        j += 1;
                    }
                    while(k > j && nums[k] == nums[k - 1]){
                        k -= 1;
                    }
                    j += 1;
                    k -= 1;
                }
            }
        }
        return ans;
    }
}
