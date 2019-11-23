public class _300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] ans = new int[nums.length];
        ans[0] = 1;
        int res = ans[0];
        for (int i = 1; i < nums.length; i += 1){
            int count = 1;
            for (int j = 0; j < i; j += 1){
                if (nums[j] < nums[i]){
                    count = Math.max(count, ans[j] + 1);
                }
            }
            ans[i] = count;
            res = Math.max(res, ans[i]);
        }

        return res;
    }
}
