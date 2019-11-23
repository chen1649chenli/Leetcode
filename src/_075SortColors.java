public class _075SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int lo = 0, hi = nums.length - 1;
        for (int i = lo; i <= hi; i += 1){
            if (nums[i] == 0){
                swap(nums, lo, i);
                lo += 1;
            } else if (nums[i] == 2){
                swap(nums, hi, i--);
                hi -= 1;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
