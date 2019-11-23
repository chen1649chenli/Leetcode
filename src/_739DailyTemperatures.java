public class _739DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return null;

        int n = T.length;
        int[] res = new int[n];
        int[] arr = new int[n];

        for (int i = n - 1; i >= 0; i -= 1){
            int next = i + 1;
            while(next < n && T[i] >= T[next]){
                next = arr[next];
            }
            arr[i] = next;
            if (next == n) res[i] = 0;
            else res[i] = next - i;
        }
        return res;
    }
}
