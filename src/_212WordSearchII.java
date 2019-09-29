import java.util.ArrayList;
import java.util.List;

public class _212WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for (String word : words){
            if (exist(board, word)) ans.add(word);
        }
        return ans;
    }

    private boolean exist(char[][] board, String word){
        if (board == null || board.length == 0 || word == null || word.length() == 0) return false;
        int r = board.length, c = board[0].length;
        for (int i = 0; i < r; i += 1){
            for (int j = 0; j < c; j += 1){
                if (board[i][j] == word.charAt(0)){
                    if(backtrack(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int len){
        if (len == word.length()) return true;
        int r = board.length - 1;
        int c = board[0].length - 1;
        if (i < 0 || i > r || j < 0 || j > c || word.charAt(len) != board[i][j]) return false;
        board[i][j] ^= 256;
        boolean ans = backtrack(board, word, i + 1, j, len + 1)
                || backtrack(board, word, i - 1, j, len + 1)
                || backtrack(board, word, i, j - 1, len + 1)
                || backtrack(board, word, i, j + 1, len + 1);

        board[i][j] ^= 256;
        return ans;
    }
}
