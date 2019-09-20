//        59. Spiral Matrix II
//        Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//        Example:
//
//        Input: 3
//        Output:
//        [
//        [ 1, 2, 3 ],
//        [ 8, 9, 4 ],
//        [ 7, 6, 5 ]
//        ]

public class _059SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;
        while(top <= bottom && left <= right){
            for (int i = left; i <= right; i += 1){
                ans[top][i] = num;
                num += 1;
            }
            top += 1;

            for (int i = top; i <= bottom; i += 1){
                ans[i][right] = num;
                num += 1;
            }
            right -= 1;

            for (int i = right; i >= left; i -= 1){
                ans[bottom][i] = num;
                num += 1;
            }
            bottom -= 1;

            for (int i = bottom; i >= top; i -= 1){
                ans[i][left] = num;
                num += 1;
            }
            left += 1;
        }
        return ans;
    }
}
