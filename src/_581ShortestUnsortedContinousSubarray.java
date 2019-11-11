import java.util.Arrays;

public class _581ShortestUnsortedContinousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int lo = -1, hi = -2, min = nums[n - 1], max=nums[0];
        for (int i = 1; i < nums.length; i += 1){
            max = Math.max(max, nums[i]);
            if (nums[i] < max) hi = i;
            min = Math.min(min, nums[n - 1 - i]);
            if (nums[n - 1 - i] > min) lo = n - 1 - i;
        }
        return hi - lo + 1;
    }
}
