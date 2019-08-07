public class _560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int size = nums.length;
        int count = 0;
        for (int i = 0; i < size; i++){
            int sum = 0;
            for (int j = i; j < size; j ++){
                sum += nums[j];
                if (sum == k){
                    count += 1;
                }
            }
        }
        return count;
    }
}
