import java.util.*;

public class _560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int size = nums.length, sum = 0, count = 0;
        Map<Integer, Integer> dict = new HashMap<>();

        dict.put(0, 1);
        for (int i = 0; i < size; i++) {
            sum += nums[i];
            if (dict.containsKey(sum - k)){
                count = count + dict.get(sum - k);
            }
            dict.put(sum, dict.getOrDefault(sum, 0) + 1);
        }
         return count;
    }
}
