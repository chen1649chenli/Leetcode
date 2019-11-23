public class _096UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n <= 1) return 1;
        int[] ans = new int[n + 1];

        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i <= n; i += 1){
            int sum = 0;
            for (int j = 1; j <= i; j += 1){
                sum += ans[j - 1] * ans[i - j];
            }
            ans[i] += sum;
        }
        return ans[n];
    }
}
