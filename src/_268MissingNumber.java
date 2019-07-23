public class _268MissingNumber {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i += 1){
            ans ^= nums[i] ^ i;
        }
        return ans ^ nums.length;
    }
}
