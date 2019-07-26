public class _276PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;

        /**numWays = numWaysPaintSame + numWaysPaintDifferent
         * numWaysPaintSame: same as previous post
         * numWaysPaintDifferent: not same as previous post */
        int numWaysPaintSame = k;
        int numWaysPaintDifferent = k * (k - 1);
        for (int i = 2; i < n; i += 1){
            int tmp = numWaysPaintSame;
            numWaysPaintSame = numWaysPaintDifferent;
            numWaysPaintDifferent = (tmp + numWaysPaintDifferent) * (k - 1);
        }
        return numWaysPaintSame + numWaysPaintDifferent;
    }
}
