import java.util.Arrays;

public class _475Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        if (houses == null || houses.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < houses.length; i += 1){
            max = Math.max(max, helper(heaters, houses[i]));
        }
        return max;
    }

    private int helper(int[] heaters, int pos){
        int low = 0;
        int high = heaters.length - 1;
        if (heaters.length == 1){
            return Math.abs(pos - heaters[0]);
        }
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if (heaters[mid] > pos){
                high = mid;
            } else if (heaters[mid] < pos){
                low = mid;
            } else {
                return 0;
            }
        }
        return Math.min(Math.abs(heaters[low] - pos), Math.abs(heaters[high] - pos));
    }
}
