public class _289GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;

        /** row number*/
        int m = board.length;

        /** column number*/
        int n = board[0].length;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int count = liveNeighbor(board, i, j, m, n);
                if (board[i][j] == 1 && count < 2){
                    board[i][j] = 1;
                } else if(board[i][j] == 1 && (count == 2 || count == 3)){
                    board[i][j] = 3;
                } else if(board[i][j] == 1 && count > 3 ){
                    board[i][j] = 1;
                } else if (board[i][j] == 0 && count == 3){
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 2){
                    board[i][j] = 1;
                }else if (board[i][j] == 1){
                    board[i][j] = 0;
                }else if (board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    private int liveNeighbor(int[][] board, int i, int j, int m, int n){
        int[][] neighbors = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int count = 0;
        for (int[] neighbor: neighbors){
            int row = neighbor[0] + i;
            int col = neighbor[1] + j;

            if (row >=0 && row < m && col >= 0 && col < n){
                if (board[row][col] == 1 ||board[row][col] == 3) count ++;
            }
        }
        return count;
    }
}
