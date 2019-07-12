public class _204CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2;i < n; i += 1){
            if (isPrime[i] == false){
                count += 1;
                for (int j = 2; j * i < n; j += 1){
                    isPrime[i * j] = true;
                }
            }

        }
        return count;
    }
}
