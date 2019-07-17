public class _069Sqrt {
    public int mySqrt(int x) {
        if (x == 1 || x== 0) return x;
        long low = 0, high = x / 2, ans = 0;
        while (low  <= high){
            long mid = (low + high) / 2;
            if (mid * mid > x){
                high = mid - 1;
            } else if (mid * mid < x){
                low = mid + 1;
                ans = mid;
            } else {
                return (int)mid;
            }
        }
        return (int)ans;
    }

}
