import java.util.HashMap;
import java.util.Map;

public class _169MajorityElement {
    public int majorityElement(int[] nums) {
        int[] ans = new int[32];
        for (int num: nums){
            for (int j = 0; j < 32; j += 1){
                int res = getBit(num, j);
                if (res == 0) ans[j]++;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i += 1){
            res = (ans[i] > nums.length /2) ? res: setBit(res, i);
        }
        return res;
    }

    private int getBit(int num, int pos){
        return ((num & (1 << pos)) == 0) ? 0: 1;
    }

    private int setBit(int num, int pos){
        int mask = 1<<pos;
        return num|mask;
    }
}
