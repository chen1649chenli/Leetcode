import java.util.ArrayList;
import java.util.List;

public class _054SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        loop(ans, matrix, visited, 0, 0, 0);
        return ans;
    }

    private void loop(List<Integer> ans, int[][] matrix, boolean[][] visited, int i, int j, int dir){
        ans.add(matrix[i][j]);
        visited[i][j] = true;
        if(dir == 0){
            if (j < matrix[0].length - 1 && !visited[i][j+1]){
                loop(ans, matrix, visited, i, j + 1, 0);
            }else if (i < matrix.length - 1 && !visited[i + 1][j]){
                loop(ans, matrix, visited, i + 1, j , 1);
            }else{
                return;
            }
        }else if(dir == 1){
            if (i < matrix.length - 1 && !visited[i + 1][j]){
                loop(ans, matrix, visited, i + 1, j, 1);
            }else if (j > 0 && !visited[i][j - 1]){
                loop(ans, matrix, visited, i, j - 1, 2);
            }else{
                return;
            }
        }else if (dir == 2){
            if (j > 0 && !visited[i][j - 1]){
                loop(ans, matrix, visited, i, j - 1, 2);
            }else if (i > 0 && !visited[i - 1][j]){
                loop(ans, matrix, visited, i - 1, j, 3);
            }else{
                return;
            }
        }else if (dir == 3){
            if (i > 0 && !visited[i - 1][j]){
                loop(ans, matrix, visited, i - 1, j, 3);
            }else if (j < matrix[0].length - 1 && !visited[i][j+1]) {
                loop(ans, matrix, visited, i, j + 1, 0);
            }else{
                return;
            }
        }
    }
}
