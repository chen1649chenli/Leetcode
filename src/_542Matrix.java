import java.util.LinkedList;
import java.util.Queue;

public class _542Matrix {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i += 1){
            for (int j = 0; j < n; j += 1){
                if (matrix[i][j] == 0){
                    q.offer(new int[]{i, j});
                }else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(q.size() > 0){
            int[] cell = q.poll();
            int i = cell[0];
            int j = cell[1];
            for (int[] dir : dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[i][j] + 1){
                    continue;
                }
                matrix[r][c] = matrix[i][j] + 1;
                q.offer(new int[]{r, c});
            }
        }
        return matrix;
    }
}
