public class _221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] data = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i += 1){
            data[i][0] = 0;
        }

        for (int j = 0; j < n + 1; j += 1){
            data[0][j] = 0;
        }
        int res = 0;
        for (int i = 1; i < m + 1; i += 1){
            for (int j = 1; j < n + 1; j += 1){
                if (matrix[i - 1][j - 1] == '0'){
                    data[i][j] = 0;
                }else{
                    data[i][j] = min(data[i - 1][j],data[i][j - 1], data[i - 1][j - 1]) + 1;
                    res = Math.max(data[i][j], res);
                }
            }
        }
        return res * res;
    }

    private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
