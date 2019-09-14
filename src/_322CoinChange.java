public class _322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;
        for (int i = 1; i <= amount; i += 1){
            for (int coin: coins){
                if (i - coin >= 0 && cache[i - coin] != Integer.MAX_VALUE){
                    cache[i] = Math.min(cache[i - coin] + 1, cache[i]);
                }
            }
        }
        if (cache[amount] == Integer.MAX_VALUE) return -1;
        return cache[amount];
    }
}
