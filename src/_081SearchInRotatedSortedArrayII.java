public class _081SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length - 1;
        int minPos = findMinInndex(nums);
        if (nums[minPos] == target || nums[n] == target) return true;
        int l = (target > nums[n])? 0: minPos;
        int h = (target > nums[n])? minPos - 1: n;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }

    private int findMinInndex(int[] nums){
        int l = 0, h = nums.length - 1;
        while(l < h && nums[l] == nums[h]){
            l++;
        }
        while (l < h){
            int mid = l + (h - l) / 2;
            if (nums[mid] > nums[h]){
                l = mid + 1;
            }else {
                h = mid;
            }
        }
        return l;
    }
}
