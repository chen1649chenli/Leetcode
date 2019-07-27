import java.util.Arrays;
import java.util.Collections;

public class _1005MaximizeSum {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int i, sum = 0;
        for (i = 0; i < A.length; i += 1){
            if (A[i] >= 0 || K == 0) break;
            if (A[i] < 0 && K > 0){
                A[i] = -A[i];
                K -= 1;
            }
        }
        if (K > 0 && K % 2 == 1){
            Arrays.sort(A);
            A[0] = -A[0];
        }

        for (int j: A){
            sum += j;
        }
        return sum;
    }
}
