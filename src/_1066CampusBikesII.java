import java.util.ArrayList;
import java.util.List;

public class _1066CampusBikesII {
    int min = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {

        if (workers == null || workers.length == 0) return 0;
        backtrack(workers, bikes,  new boolean[bikes.length], 0, 0);
        return min;
    }

    private void backtrack(int[][] workers, int[][] bikes,   boolean[] usedBike, int singleSum, int count){
        if (count == workers.length){
            this.min = Math.min(this.min, singleSum);
            return;
        }

        if (singleSum > this.min) return;

        for (int i = 0; i < bikes.length; i += 1){
            if (usedBike[i]) continue;

            usedBike[i] = true;
            backtrack(workers, bikes, usedBike, singleSum + getDistance(workers[count], bikes[i]), count + 1);
            usedBike[i] = false;
        }
    }

    private int getDistance(int[] _a, int[] _b){
        return Math.abs(_a[0] - _b[0]) + Math.abs(_a[1] - _b[1]);
    }
}
