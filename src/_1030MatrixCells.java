import java.util.Arrays;
import java.util.Comparator;

public class _1030MatrixCells {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R* C][2];
        int count = 0;
        for (int i = 0; i < R; i += 1){
            for (int j = 0; j < C; j += 1){
                ans[count++] = new int[]{i, j};
            }
        }
        Arrays.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0) - Math.abs(o2[0] - r0) - Math.abs(o2[1] - c0);
            }
        });
        return ans;
    }
}
