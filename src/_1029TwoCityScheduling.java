import java.util.Arrays;
import java.util.Comparator;

public class _1029TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int delta1 = o1[1] - o1[0];
                int delta2 = o2[1] - o2[0];
                return delta1 - delta2;
            }
        });

        int size = costs.length;
        int sum = 0;
        for (int i = 0; i < size / 2; i += 1){
            sum += costs[i][1];
        }
        for (int i = size/2; i < size; i += 1){
            sum += costs[i][0];
        }
        return sum;
    }
}
