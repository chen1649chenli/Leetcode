public class _461HammingDistance {
    public int hammingDistance(int x, int y) {
        int sum = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i += 1){
            if ((sum & 1) == 1) count += 1;
            sum = sum >> 1;
        }
        return count;
    }
}
