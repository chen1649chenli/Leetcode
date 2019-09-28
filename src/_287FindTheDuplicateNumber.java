public class _287FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while(lo + 1 < hi){
            int mid = (hi - lo) / 2 + lo;
            int count = 0;
            for (int i = 0; i < nums.length; i += 1){
                if (nums[i] - 1 <= mid){
                    count += 1;
                }
            }
            if (count > mid + 1){
                hi = mid;
            }else{
                lo = mid;
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i += 1){
            if (nums[i] - 1 == lo) count ++;
        }
        return (count > 1)? lo + 1: hi + 1;
    }
}
