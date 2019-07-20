import java.util.Arrays;
import java.util.Collections;

public class _976LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        int size = A.length;
        if (size < 3) return 0;
        Arrays.sort(A);
        for (int i = size - 1; i >= 2; i -= 1){
            if (A[i - 2] > A[i] - A[i - 1]) return A[i] + A[i - 1] + A[i - 2];
        }
        return 0;
    }
}
