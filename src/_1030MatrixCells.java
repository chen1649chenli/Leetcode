import java.util.*;

public class _1030MatrixCells {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][2];
        int count = 0;
        LinkedList<int[]>[] arr = new LinkedList[R + C];
        for (int k = 0; k < R + C; k ++){
            arr[k] = new LinkedList<>();
        }
        for (int i = 0; i < R; i += 1){
            for (int j = 0; j < C; j += 1){
                int dist = Math.abs(i - r0) + Math.abs(j - c0);
                arr[dist].add(new int[]{i, j});
            }
        }
        for (LinkedList<int[]> k : arr){
            while (!k.isEmpty()){
                ans[count++] = k.pollFirst();
            }
        }
        return ans;
    }
}
