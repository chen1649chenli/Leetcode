public class _875KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        for (int i : piles){
            max = Math.max(i, max);
        }
        int lo = 1, hi = max + 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for (int pile : piles){
                count += (pile + mid - 1) / mid;
            }
            if (count <= H){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }
}
