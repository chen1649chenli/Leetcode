public class _033SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return -1;

        int minIndex = findMin(nums);
        if (nums[minIndex] == target) return minIndex;

        int len = nums.length;
        int l = (target > nums[len - 1])? 0 : minIndex;
        int h = (target > nums[len - 1])? minIndex - 1: len -1;

        while( l <= h){
            int mid = l + (h - l ) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }
        return -1;
    }


    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while(l < h){
            int mid = l + (h - l)/2;
            if (nums[mid] > nums[h]){
                l = mid + 1;
            }else{
                h = mid;
            }
        }
        return l;
    }
}
