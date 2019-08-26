import java.util.ArrayList;
import java.util.List;

public class _448FindAllNumbersDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i : nums){
            nums[Math.abs(i) - 1] = -1 * Math.abs(nums[Math.abs(i) - 1]);
        }
        for (int i = 0; i < n; i += 1){
            if (nums[i] < 0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
