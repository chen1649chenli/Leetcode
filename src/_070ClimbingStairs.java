public class _070ClimbingStairs {
    public int climbStairs(int n) {
        int[] ans = new int[n+1];
        ans[1] = 1;
        ans[0] = 0;
        for (int i = 2; i <= n + 1; i += 1){
            ans[i] = ans[i-2] + ans[i-1];
        }
        return ans[n+1];
    }
}
