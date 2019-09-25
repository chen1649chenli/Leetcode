public class _153FindMinimumInRotatedSortArray {
    public int findMin(int[] nums) {
        int n = nums.length, lo = 0, hi = n - 1;
        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        return (nums[lo] < nums[hi])? nums[lo]: nums[hi];
    }

}
