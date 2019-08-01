public class _647PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s.length() < 2) return s.length();
        int n = s.length();
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < n; i += 1){
            matrix[i][i] = true;
        }
        for (int layer = 1; layer < n; layer ++){
            for (int x = 0; x < n - layer; x++){
                int y = x + layer;
                if (s.charAt(x) == s.charAt(y)){
                    if (y == x + 1){
                        matrix[x][y] = true;
                    }else if (y > x + 1 && matrix[x+1][y-1] == true){
                        matrix[x][y] = true;
                    }
                }
            }
        }
        int count = 0;
        for (int x = 0; x < n; x ++){
            for (int y = x; y < n; y ++){
                if (matrix[x][y]) {
                    count++;
                    System.out.println("x, y: " + x + " " + y);
                }
            }
        }
        return count++;
    }
}
