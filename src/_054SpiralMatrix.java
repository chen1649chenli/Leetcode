import java.util.ArrayList;
import java.util.List;

public class _054SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;
        int left = 0, top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int total = (right + 1) * (bottom + 1);

        while(ans.size() < total){
            for (int i = left; ans.size() < total && i <= right; i++){
                ans.add(matrix[top][i]);
            }

            for (int i = top + 1; ans.size() < total && i <= bottom; i++){
                ans.add(matrix[i][right]);
            }

            for (int i = right - 1; ans.size() < total && i >= left; i--){
                ans.add(matrix[bottom][i]);
            }

            for (int i = bottom - 1; ans.size() < total && i >= top + 1; i--){
                ans.add(matrix[i][left]);
            }
            left++; right--; top++; bottom--;
        }
        return ans;
    }
}
