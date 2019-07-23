import java.util.HashMap;
import java.util.Map;

public class _169MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i += 1){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i: map.keySet()){
            if (map.get(i) > nums.length / 2) return i;
        }
        return 0;
    }
}
