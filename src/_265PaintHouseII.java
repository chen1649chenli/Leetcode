public class _265PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        int k = costs[0].length;
        int n = costs.length;
        int min1 = -1, min2 = -1;

        for (int i = 0; i < n; i += 1){
            int prev1 = min1, prev2 = min2;
            min1 = -1;
            min2 = -1;
            for (int j = 0; j < k; j += 1){
                if (j != min1){
                    costs[i][j] += (prev1 < 0) ? 0: costs[i - 1][prev1] ;
                } else{
                    costs[i][j] += (prev2 < 0) ? 0: costs[i - 1][prev2] ;
                }
                if (min1 < 0 || costs[i][j] < costs[i][min1]){
                    min2 = min1;
                    min1 = j;
                }else if (min2 < 0 || costs[i][j] < costs[i][min2]){
                    min2 = j;
                }
            }
        }

        return costs[n-1][min1];
    }
}
