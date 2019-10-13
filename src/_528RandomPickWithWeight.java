import java.util.Random;

class _528RandomPickWithWeight {
    int[] nums;
    int[] arr;

    public _528RandomPickWithWeight(int[] w) {
        this.arr = w;
        nums = new int[w.length];
        for (int i = 0; i < w.length; i += 1){
            if (i == 0){
                nums[i] = w[i];
            }else{
                nums[i] = nums[i - 1] + w[i];
            }
        }
    }

    public int pickIndex() {
        Random rand = new Random();
        int val = rand.nextInt(nums[nums.length - 1]);
        int idx = binarySearch(nums, val, 0, nums.length - 1);
        return idx;
    }

    private int binarySearch(int[] nums, int target, int lo, int hi){
        while(lo + 1 < hi){
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] == target){
                return mid + 1;
            }else if (nums[mid] < target){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        if (nums[hi] == target) return hi + 1;
        return (nums[lo] <= target) ? hi: lo;
    }

}
