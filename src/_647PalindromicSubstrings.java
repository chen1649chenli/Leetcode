public class _647PalindromicSubstrings {
    int count;

    public int countSubstrings(String s) {
        if (s.length() < 2) return s.length();
        int n = s.length();
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < n; i++){
            expand(s, matrix, i, i);
            expand(s, matrix, i, i + 1);
        }
        return count;
    }
    private void expand(String s, boolean[][] m, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            m[i][j] = true;
            count++;
            i--; j++;
        }
    }
}
