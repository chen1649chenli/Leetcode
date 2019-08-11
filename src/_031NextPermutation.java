import java.util.Arrays;

public class _031NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int firstSmall = -1;
        for (int i = nums.length - 2;  i >= 0; i--){
            if (nums[i] < nums[i+1]){
                firstSmall = i;
                break;
            }
        }
        if (firstSmall == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (int i = nums.length - 1; i > firstSmall; i--){
            if (nums[i] > nums[firstSmall]){
                swap(nums, i, firstSmall);
                break;
            }
        }
        reverse(nums, firstSmall+ 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j){
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }

    private void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i++, j--);
        }
    }
}
