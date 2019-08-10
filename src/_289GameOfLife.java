public class _289GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;


        int row = board.length;
        int col = board[0].length;
        int[][] original = new int[row][col];

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                original[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                update(board, original, i, j);
            }
        }
    }

    private void update(int[][] board, int[][] original, int i, int j){
        int row = board.length - 1;
        int col = board[0].length - 1;
        int count = 0;
        if (i > 0 && original[i - 1][j] == 1) count++;
        if (i < row && original[i + 1][j] == 1) count ++;
        if (j > 0 && original[i][j - 1] == 1) count++;
        if (j < col && original[i][j + 1] == 1) count++;
        if (i > 0 && j > 0 && original[i - 1][j - 1] == 1) count ++;
        if (i < row && j > 0 && original[i+1][j - 1] == 1) count ++;
        if (i > 0 && j < col && original[i -1][j+1] == 1) count ++;
        if (i < row && j < col && original[i + 1][j + 1] == 1) count++;

        if (count < 2){
            board[i][j] = 0;
        }else if(count == 3){
            board[i][j] = 1;
        }else if(count > 3){
            board[i][j] = 0;
        }
    }
}
