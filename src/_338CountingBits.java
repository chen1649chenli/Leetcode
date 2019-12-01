public class _338CountingBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i <= num; i += 1){
            ans[i] = (ans[i>>1] + (i & 1));
        }
        return ans;
    }
}
