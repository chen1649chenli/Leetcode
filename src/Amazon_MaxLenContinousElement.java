import java.util.HashMap;
import java.util.Map;

public class Amazon_MaxLenContinousElement {
    int max = 0;
    public int getMax(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) continue;
            if (!map.containsKey(i - 1) && !map.containsKey(i + 1)) {
                map.put(i, new int[]{i, i});
            } else if (map.containsKey(i - 1) && map.containsKey(i + 1)) {
                int lo = map.get(i - 1)[0];
                int hi = map.get(i + 1)[1];
                map.put(i, new int[]{lo, hi});
                map.put(i - 1, new int[]{lo, hi});
                map.put(i + 1, new int[]{lo, hi});
            } else if (map.containsKey(i - 1)) {
                int lo = map.get(i - 1)[0];
                int hi = i;
                map.put(i, new int[]{lo, hi});
                map.put(i - 1, new int[]{lo, hi});
            } else {
                int hi = map.get(i + 1)[1];
                int lo = i;
                map.put(i, new int[]{lo, hi});
                map.put(i + 1, new int[]{lo, hi});
            }
            this.max = Math.max(max, map.get(i)[1] - map.get(i)[0] + 1);
        }
        return this.max;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1, 3, 8, 2, 5};
        Amazon_MaxLenContinousElement app = new Amazon_MaxLenContinousElement();
        System.out.println(app.getMax(arr));
    }
}
