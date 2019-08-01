public class _215KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSelect(int[] nums, int l, int h, int k){
        if (l == h) return nums[l];
        int idx = partition(nums, l, h);
        if (idx == k) {
            return nums[k];
        }else if(idx < k){
            return quickSelect(nums, idx + 1, h, k);
        }else{
            return quickSelect(nums, l, idx - 1, k);
        }
    }

    private int partition(int[] nums, int l, int h){
        int pivot = nums[l];
        int pIndex = l;
        swap(nums, l, h);
        for (int i = l; i < h; i++){
            if(nums[i] > pivot){
                swap(nums, i, pIndex);
                pIndex++;
            }
        }
        swap(nums, pIndex, h);
        return pIndex;
    }

    private void swap(int[] nums, int i, int j){
        int swapTmp = nums[i];
        nums[i] = nums[j];
        nums[j] = swapTmp;
    }
}
