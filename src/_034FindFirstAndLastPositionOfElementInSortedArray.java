public class _034FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int[] res = new int[2];
        res[0] = findLowBound(nums, target);
        res[1] = findHighBound(nums, target);
        if (res[0] <= res[1])return res;
        else return new int[]{-1, -1};
    }

    private int findLowBound(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return lo;
    }

    private int findHighBound(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return hi;
    }
}
