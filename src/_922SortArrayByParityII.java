import java.util.Stack;

public class _922SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int odd = 1, even = 0, size = A.length;
        while(odd < size   && even < size - 1 ){
            while(odd < size && A[odd] % 2 == 1 ){
                odd += 2;
            }
            while(even < size && A[even] % 2 == 0 ){
                even += 2;
            }
            if (odd < size && even < size - 1){
                int tmp = A[odd];
                A[odd] = A[even];
                A[even] = tmp;
                odd += 2;
                even += 2;
            }

        }
        return A;
    }
}
