import java.util.Arrays;

public class _581ShortestUnsortedContinousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] tmp = nums.clone();
        Arrays.sort(tmp);

        int start = 0, end = nums.length -1;

        while(start < nums.length && nums[start] == tmp[start]){
            start += 1;
        }

        while(end > start && nums[end] == tmp[end]){
            end -= 1;
        }

        return end - start + 1;
    }
}
