public class _733FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        boolean[][] visited = new boolean[row][col];
        dfs(image, visited, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, boolean[][] visited, int sr, int sc, int newColor){
        int ori = image[sr][sc];
        visited[sr][sc] = true;
        image[sr][sc] = newColor;

        if (sr - 1 >= 0 && !visited[sr -1][sc] && image[sr - 1][sc] == ori){
            dfs(image, visited, sr - 1, sc, newColor);
        }
        if (sr + 1 < image.length && !visited[sr + 1][sc] && image[sr + 1][sc] == ori){
            dfs(image, visited, sr + 1, sc, newColor);
        }
        if (sc - 1 >= 0 && !visited[sr][sc - 1] && image[sr][sc - 1] == ori){
            dfs(image, visited, sr, sc -1, newColor);
        }
        if (sc + 1 < image[0].length && !visited[sr][sc + 1] && image[sr][sc + 1] == ori){
            dfs(image, visited, sr, sc + 1, newColor);
        }
    }
}
