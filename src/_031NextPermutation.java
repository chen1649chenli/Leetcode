import java.util.Arrays;

public class _031NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int pos = findIdx(nums);
        if (pos != 0){
            change(nums, pos);
        }
        arrange(nums, pos, nums.length - 1);
    }

    private int findIdx(int[] nums){
        int h = nums.length - 1;
        while(h >= 1 && nums[h] <= nums[h-1]){
            h--;
        }
        return h;
    }

    private void arrange(int[] nums, int l, int h){
        Arrays.sort(nums, l, h+1);
    }

    private void change(int[] nums, int pos){
        int l = nums[pos - 1];
        int idx = pos;
        int num = nums[pos];
        for (int i = pos; i < nums.length; i++){
            if (nums[i] < num && nums[i] > l){
                idx = i;
                num = nums[i];
            }
        }
        int swap = nums[idx];
        nums[idx] = l;
        nums[pos-1] = swap;
    }
}
