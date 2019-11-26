import java.util.Arrays;
public class _416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        if ((sum & 1) == 1) return false;

        int target = sum / 2;

        int n = nums.length;
        boolean[][] ans = new boolean[n + 1][target + 1];
        for (int i = 0; i < n + 1; i += 1){
            Arrays.fill(ans[i], false);
        }
        for (int i = 0; i < n + 1; i += 1){
            ans[i][0] = true;
        }

        for (int i = 1; i < n + 1; i += 1){
            for (int j = 1; j < target + 1; j += 1){
                ans[i][j] = ans[i - 1][j];
                if (j >= nums[i - 1]){
                    ans[i][j] = ans[i][j] || ans[i - 1][j - nums[i - 1]];
                }
            }
        }
        return ans[n][target];
    }
}
