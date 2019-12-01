public class _055JumpGame {
    //Solution 1: Using DP
//    public boolean canJump(int[] nums) {
//        int n = nums.length;
//        boolean[] ans = new boolean[n];
//        ans[n - 1] = true;
//        for (int i  = n - 2; i >= 0; i--){
//            for (int j = 1 ; j <= nums[i]; j += 1){
//                if (i + j < n && ans[i + j]){
//                    ans[i] = true;
//                    break;
//                }
//            }
//        }
//        return ans[0];
//    }
    //Solution 2: Greedy
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int max = 0;
        for (int i = 0; i < n; i += 1){
            if (max < i) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
