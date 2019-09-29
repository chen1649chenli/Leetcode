import java.util.Arrays;

public class _628MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE + 2, max2 = Integer.MIN_VALUE + 1, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE - 1, min2 = Integer.MAX_VALUE;

        for (int i : nums){
            if (i > max1){
                max3 = max2;
                max2 = max1;
                max1 = i;
            }else if (i > max2){
                max3 = max2;
                max2 = i;
            }else if (i > max3){
                max3 = i;
            }

            if (i < min1){
                min2 = min1;
                min1 = i;
            }else if(i < min2){
                min2 = i;
            }
        }
        int res1 = max1 * max2 * max3;
        int res2 = max1 * min1 * min2;
        return (res1 > res2)? res1: res2;
    }
}
