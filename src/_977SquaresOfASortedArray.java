public class _977SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int size = A.length;
        int[] result = new int[size];
        int i = 0, j = size - 1;
        for (int k = size - 1; k >= 0; k -= 1){
            int sum_a = A[i] * A[i];
            int sum_b = A[j] * A[j];
            if (sum_a > sum_b){
                result[k] = sum_a;
                i += 1;
            }else{
                result[k] = sum_b;
                j -= 1;
            }
        }
        return result;
    }
}
