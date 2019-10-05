import java.util.HashSet;
import java.util.Set;

public class _036ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        int len = board.length;
        for (int i = 0; i < len; i += 1){
            for (int j = 0; j < len; j += 1){
                char c = board[i][j];
                if (c != '.'){
                    if (    !set.add("row " + i + " " + c) ||
                            !set.add("col " + j + " " + c) ||
                            !set.add("grid " + i/3 + " " + j /3 + " " + c)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
