public class _378KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length, c = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[r - 1][c - 1];
        while(lo <= hi){
            int mid = (hi - lo) / 2 + lo;
            int count = 0;
            for (int i = 0; i < r; i += 1){
                if (matrix[i][0] > mid){
                    break;
                }else if (mid >= matrix[i][c - 1]){
                    count += c;
                }else{
                    for (int j = 0; j < c; j ++){
                        if (matrix[i][j] <= mid){
                            count += 1;
                        }
                    }
                }
            }
            if (count < k){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return lo;
    }
}
