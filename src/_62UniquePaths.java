public class _62UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] count = new int[m][n];
        for (int i = 0; i < m; i += 1){
            count[i][0] = 1;
        }
        for (int i = 0; i < n; i += 1){
            count[0][i] = 1;
        }
        for (int i = 1; i < m; i += 1){
            for (int j = 1; j < n; j += 1){
                count[i][j] = count[i - 1][j] + count[i][j - 1];
            }
        }
        return count[m - 1][n -1];
    }
}
