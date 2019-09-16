public class _64MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        dist[0][0] = grid[0][0];
        for (int i = 0; i < n - 1; i += 1){
            dist[0][i + 1] = dist[0][i] + grid[0][i + 1];
        }
        for (int i = 0; i < m - 1; i += 1){
            dist[i + 1][0] = dist[i][0] + grid[i + 1][0];
        }
        for (int i = 1; i < m; i += 1){
            for (int j = 1; j < n; j += 1){
                dist[i][j] = Math.min(dist[i - 1][j],dist[i][j - 1]) + grid[i][j];
            }
        }
        return dist[m - 1][n - 1];
    }
}
