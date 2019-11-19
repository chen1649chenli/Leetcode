public class _152MaximumProductSubarray {
    //solution 1: brutal force
//    public int maxProduct(int[] nums) {
//        int start = 0, end = 0, max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i += 1){
//            int product = 1;
//            for (int j = i; j < nums.length; j += 1){
//                product = product * nums[j];
//                if (product > max){
//                    max = product;
//                    start = i;
//                    end = j;
//                }
//            }
//        }
//        return max;
//    }

    //solution 2: 1D dynamic programming
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];

        int maxVal = max[0];
        for (int i = 1; i < nums.length; i += 1){
            max[i] = maxThree(nums[i], nums[i] * max[i - 1], nums[i] * min[i - 1]);
            min[i] = minThree(nums[i], nums[i] * max[i - 1], nums[i] * min[i - 1]);
            maxVal = Math.max(maxVal, max[i]);
        }
        return maxVal;
    }

    private int maxThree(int a, int b, int c){
        int big = Math.max(a, b);
        return Math.max(big, c);
    }

    private int minThree(int a, int b, int c){
        int small = Math.min(a, b);
        return Math.min(small, c);
    }

}
