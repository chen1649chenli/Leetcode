public class _079WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        int m  = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == word.charAt(0)){
                    if (helper(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int k){
        if (k == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(k)) return false;
        board[i][j] ^= 256;
        boolean ans = helper(board, word, i + 1, j, k+1)
                || helper(board, word, i - 1, j, k+1)
                || helper(board, word, i, j + 1, k+1)
                || helper(board, word, i, j - 1, k+1);
        board[i][j] ^= 256;
        return ans;
    }
}
