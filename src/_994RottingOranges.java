import java.util.*;
public class _994RottingOranges {
    public int orangesRotting(int[][] grid) {
        int min = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i += 1){
            for (int j = 0; j < col; j += 1){
                if (grid[i][j] == 1){
                    boolean[][] visited = new boolean[row][col];
                    int dist = bfs(grid, i, j, visited);
                    min = Math.max(min, dist);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int bfs(int[][] grid, int r, int c, boolean[][] visited){
        int level = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        q.offer(null);
        while(q.size() > 1){
            int[] dot = q.poll();
            if (dot == null) {
                level += 1;
                q.offer(null);
                continue;
            }
            visited[dot[0]][dot[1]] = true;
            if (grid[dot[0]][dot[1]] == 2){
                return level;
            }
            if (dot[0] - 1 >= 0 && grid[dot[0] - 1][dot[1]] != 0 && !visited[dot[0] - 1][dot[1]]) {
                q.offer(new int[]{dot[0] - 1, dot[1]});
            }
            if (dot[0] + 1 < grid.length && grid[dot[0] + 1][dot[1]] != 0 && !visited[dot[0] + 1][dot[1]]) {
                q.offer(new int[]{dot[0] + 1, dot[1]});
            }
            if (dot[1] - 1 >= 0 && grid[dot[0]][dot[1] - 1] != 0 && !visited[dot[0]][dot[1] - 1]) {
                q.offer(new int[]{dot[0], dot[1] - 1});
            }
            if (dot[1] + 1 < grid[0].length && grid[dot[0]][dot[1] + 1] != 0 && !visited[dot[0]][dot[1] + 1]) {
                q.offer(new int[]{dot[0], dot[1] + 1});
            }
        }
        return Integer.MAX_VALUE;
    }
}
