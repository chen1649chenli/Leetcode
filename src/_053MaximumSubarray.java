public class _053MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null) return 0;

        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i += 1){
            ans[i] = Math.max(ans[i - 1] + nums[i], nums[i]);
            max = Math.max(max, ans[i]);
        }
        return max;
    }
}
