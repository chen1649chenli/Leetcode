public class _256PaintHouse {
    public int minCost(int[][] costs) {
        if (costs.length == 0 || costs == null) return 0;
        for (int i = 1; i < costs.length; i += 1){
            costs[i][0] = Math.min(costs[i][0] + costs[i - 1][1], costs[i][0] + costs[i - 1][2]);
            costs[i][1] = Math.min(costs[i][1] + costs[i - 1][0], costs[i][1] + costs[i - 1][2]);
            costs[i][2] = Math.min(costs[i][2] + costs[i - 1][0], costs[i][2] + costs[i - 1][1]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i += 1){
            min = Math.min(min, costs[costs.length - 1][i]);
        }
        return min;
    }
}
