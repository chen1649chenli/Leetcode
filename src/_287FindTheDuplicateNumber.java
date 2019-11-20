public class _287FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int lo = 1, hi = nums.length -1;
        while(lo <= hi){
            int mid = (hi - lo) / 2 + lo;
            int count = 0;
            for (int i = 0; i < nums.length; i += 1){
                if (nums[i] <= mid){
                    count += 1;
                }
            }
            if (count <= mid){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return hi + 1;
    }
}
