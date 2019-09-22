public class _162FindPeakElement {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1]){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        return (nums[lo] < nums[hi])? hi : lo;
    }
}
