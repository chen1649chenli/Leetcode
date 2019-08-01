public class _200NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0;j < m; j++){
                if (!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(visited, grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(boolean[][] visited, char[][] grid, int i, int j){
        visited[i][j] = true;
        if (i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == '1') dfs(visited, grid, i - 1, j);
        if (i + 1 < grid.length && !visited[i + 1][j] && grid[i + 1][j] == '1') dfs(visited, grid, i + 1, j);
        if (j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == '1') dfs(visited, grid, i, j - 1);
        if (j + 1 < grid[0].length && !visited[i][j + 1] && grid[i][j + 1] == '1') dfs(visited, grid, i, j + 1);
    }
}
