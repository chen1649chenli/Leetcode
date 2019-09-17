import java.util.Arrays;

public class AmazonOA_TwoSumUniquePairs {
    public int findPairs(int[] nums, int target){
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1, res = 0;
        while(lo < hi){
            int sum = nums[lo] + nums[hi];
            if (sum < target){
                lo += 1;
            }else if (sum > target){
                hi -= 1;
            }else{
                res += 1;
                while(lo < hi && nums[lo] == nums[lo + 1]){
                    lo += 1;
                }
                while(hi > lo && nums[hi] == nums[hi - 1]){
                    hi -= 1;
                }
                lo += 1; hi -= 1;
            }
        }
        return res;
    }
}
