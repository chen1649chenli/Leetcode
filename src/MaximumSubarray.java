public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int max = result[0];

        for (int i = 1; i < nums.length; i++){
            result[i] = Math.max(result[i-1] + nums[i], nums[i]);
            max  = Math.max(max, result[i]);
        }
        return max;
    }
}
