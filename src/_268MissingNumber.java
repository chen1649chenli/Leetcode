public class _268MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i += 1){
            sum += (nums[i] - i);
        }
        return nums.length - sum;
    }
}
