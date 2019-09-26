import java.util.PriorityQueue;

public class _407TrappingRainWaterII {
    class cell {
        int r, c, h;
        cell(int r, int c, int h){
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        PriorityQueue<cell> pq = new PriorityQueue<>((a, b)->(a.h - b.h));

        int row = heightMap.length;
        int col = heightMap[0].length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        boolean[][] visited = new boolean[row][col];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < col; i += 1){
            pq.offer(new cell(0, i, heightMap[0][i]));
            visited[0][i] = true;
        }
        for (int i = 0; i < col; i += 1){
            pq.offer(new cell(row - 1, i, heightMap[row - 1][i]));
            visited[row - 1][i] = true;
        }
        for (int i = 1; i < row - 1; i += 1){
            pq.offer(new cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
        }
        for (int i = 1; i < row - 1; i += 1){
            pq.offer(new cell(i, col - 1, heightMap[i][col - 1]));
            visited[i][col - 1] = true;
        }
        while(!pq.isEmpty()){
            cell curr = pq.poll();
            max = Math.max(max, curr.h);
            sum += max - curr.h;
            for (int[] dir: dirs){
                int j = dir[0] + curr.r;
                int k = dir[1] + curr.c;
                if (j< 0 || j >=row || k < 0 || k >= col || visited[j][k]){
                    continue;
                }
                pq.offer(new cell(j, k, heightMap[j][k]));
                visited[j][k] = true;
            }
        }
        return sum;
    }
}
