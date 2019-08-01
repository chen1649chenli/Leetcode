public class _005LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return null;
        int n = s.length();
        int[][] matrix = new int[n][n];
        for (int t = 0; t < n; t += 1){
            matrix[t][t] = 1;
        }
        String ans = s.substring(0,1);
        for (int layer = 1; layer < n; layer++){
            for (int x = 0; x < n - layer; x++){
                int y = x + layer;
                if (s.charAt(x) == s.charAt(y)){
                    if (x + 1 == y){
                        matrix[x][y] = 2;
                    }else if (matrix[x+1][y-1] > 0){
                        matrix[x][y] = matrix[x+1][y-1] + 2;
                    } else{
                        matrix[x][y] = 0;
                    }
                }else{
                    matrix[x][y] = 0;
                }
                if (matrix[x][y] > ans.length()){
                    ans = s.substring(x, y + 1);
                }
            }
        }
        return ans;
    }
}
