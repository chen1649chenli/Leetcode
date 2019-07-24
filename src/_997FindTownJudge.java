public class _997FindTownJudge {
    public int findJudge(int N, int[][] trust) {
        int count[] = new int[N + 1];
        for (int[] relation: trust){
            count[relation[1]] += 1;
            count[relation[0]] -= 1;
        }

        for (int i = 1; i <= N; i += 1){
            if (count[i] == N - 1) return i;
        }
        return -1;

    }
}
