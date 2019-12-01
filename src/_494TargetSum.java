import java.util.ArrayList;
import java.util.List;

public class _494TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0, n = nums.length;
        for (int num: nums){
            sum += num;
        }
        if (S > sum || S < -sum) return 0;
        int[][] ans = new int[n + 1][2 * sum + 1];
        for (int i = 0; i <= 2 * sum; i += 1){
            ans[0][i] = 0;
        }
        ans[0][0 + sum] = 1;
        for (int i = 1; i <= n; i += 1){
            for (int j = 0; j <= 2 * sum; j += 1){
                if (j - nums[i - 1] >= 0){
                    ans[i][j] += ans[i - 1][j - nums[i - 1]];
                }
                if (j + nums[i - 1] <= 2 * sum){
                    ans[i][j] += ans[i - 1][j + nums[i - 1]];
                }
            }
        }
        return ans[n][sum + S];
    }
}
