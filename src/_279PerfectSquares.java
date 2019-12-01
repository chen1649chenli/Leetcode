import java.util.Arrays;

public class _279PerfectSquares {
    public int numSquares(int n) {
        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;ans[1] = 1;
        for (int i = 2; i <= n; i += 1){
            for (int j = 1; j * j <= i; j += 1){
                ans[i] = Math.min(ans[i], ans[i - j * j] + 1);
            }
        }
        return ans[n];
    }
}
