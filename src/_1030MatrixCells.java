import java.util.*;

public class _1030MatrixCells {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});
        boolean[][] visited = new boolean[R][C];
        int count = 0;
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            if (r >= R || r < 0 || c >= C || c < 0){
                continue;
            }
            if (visited[r][c]){
                continue;
            }
            visited[r][c] = true;
            ans[count++] = new int[]{r, c};
            queue.offer(new int[]{r + 1, c});
            queue.offer(new int[]{r - 1, c});
            queue.offer(new int[]{r, c + 1});
            queue.offer(new int[]{r, c - 1});
        }
        return ans;
    }
}
