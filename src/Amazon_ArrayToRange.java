import java.util.ArrayList;
import java.util.List;

public class Amazon_ArrayToRange {
    List<int[]> findRange(int[] nums){
        List<int[]> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;

        int slow = 0, fast = 0;
        while(fast < nums.length){
            while(fast < nums.length - 1 && nums[fast] + 1 == nums[fast+1]){
                fast += 1;
            }
            ans.add(new int[]{nums[slow], nums[fast]});
            fast+= 1; slow = fast;
        }
        return ans;
    }
}
