import java.util.ArrayList;
import java.util.List;

public class Amazon_LC62variant {
    public List<String> uniquePaths(char[][] map) {
        int row = map.length;
        int col = map[0].length;
        List<String> route = new ArrayList<>();
        backtrack(route, "", row, col, 0, 0, map);
        return  route;
    }

    private void backtrack(List<String> ans, String str, int row, int col, int x, int y, char[][] map){
        if (x == row - 1 && y == col - 1){
            ans.add(str + map[x][y]);
            return;
        }
        if (x >= row || y >= col ) return;
        str = str + map[x][y];
        backtrack(ans, str, row, col, x + 1, y, map);
        backtrack(ans, str, row, col, x, y + 1, map);
    }

    public static void main(String[] args){
        char[][] map = new char[][]{{'a', 'b'}, {'c', 'd'}, {'e', 'f'}};
        Amazon_LC62variant app = new Amazon_LC62variant();
        List<String> route = app.uniquePaths(map);
        for (String str: route){
            System.out.println(str);
        }
    }

}
