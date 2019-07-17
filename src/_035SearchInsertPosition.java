public class _035SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length -1, ans = 0;
        if (target < nums[0]) return 0;
        if (target > nums[end]) return nums.length;
        while(start <= end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                start = mid + 1;
                ans = start;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
}
