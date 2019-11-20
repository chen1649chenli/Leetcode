import java.util.Arrays;

public class _213HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
        int res1 = robHelper(nums1);
        int res2 = robHelper(nums2);
        return (res1 >= res2)? res1: res2;

    }

    public int robHelper(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] maxVal = new int[nums.length];
        maxVal[0] = nums[0];
        maxVal[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i += 1){
            maxVal[i] = Math.max(maxVal[i - 2] + nums[i], maxVal[i - 1]);
        }
        return maxVal[nums.length - 1];
    }
}
