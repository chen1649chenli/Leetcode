//        Find pair with maximum Appeal value.
//
//        Input: Array
//        Output: index {i, j} ( i = j allowed) with maximum Appeal
//        Appeal = A[i] +A[j] + abs(i-j)
//
//        Example 1:
//
//        Input: [1, 3, -1]
//        Output: [1, 1]
//        Explanation: Appeal = A[1] + A[1] + abs(0) = 3 + 3 + 0 = 6
//        Example 2:
//
//        Input: [1, 6, 1, 1, 1, 1, 7]
//        Output: [1, 6]
//        Explanation 6 + 7 + abs(1 - 6) = 18
//        Example 3:
//
//        Input: [6, 2, 7, 4, 4, 1, 6]
//        Output: [0, 6]
//        Explanation: 6 + 6 + abs(0 - 6) = 18



public class AmazonOA_FindPairWithMaxAppealSum {
    public int[] find(int[] arr){
        if (arr == null || arr.length == 0) return null;
        int max1 = Integer.MIN_VALUE;
        int idx1 = 0;
        int max2 = Integer.MIN_VALUE;
        int idx2 = 0;
        for (int i = 0; i < arr.length; i += 1){
            if (arr[i] + i > max1){
                max1 = arr[i] + i;
                idx1 = i;
            }
            if (arr[i] - i > max2){
                max2 = arr[i] - i;
                idx2 = i;
            }
        }
        if (idx1 < idx2){
            return new int[]{idx1, idx2};
        }else{
            return new int[]{idx2, idx1};
        }
    }
}
