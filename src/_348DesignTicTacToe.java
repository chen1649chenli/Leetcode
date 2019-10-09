public class _348DesignTicTacToe {
    private int[] row;
    private int[] col;
    private int diagonal;
    private int antidiagonal;

    /** Initialize your data structure here. */
    public _348DesignTicTacToe(int n) {
        row = new int[n];
        col = new int[n];
        diagonal = 0;
        antidiagonal = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int len = this.row.length;
        // when player 1 moves, put "1" on the grid;
        // when player 2 moves, put "-1" on the grid.
        int action = (player == 1)? 1: -1;
        this.row[row] += action;
        this.col[col] += action;
        if (row == col) this.diagonal += action;
        if (row + col == len - 1) this.antidiagonal += action;

        if (Math.abs(this.row[row]) == len || Math.abs(this.col[col]) == len || Math.abs(this.diagonal) == len || Math.abs(this.antidiagonal) == len ){
            return player;
        }else{
            return 0;
        }
    }
}
