import java.util.HashMap;
import java.util.Map;

public class _167TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        int[] result = new int[2];
        int i = 0;
        int j = size - 1;
        while (i < j){
            if (numbers[i] + numbers[j] == target){
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            } else if (numbers[i] + numbers[j] > target){
                j -= 1;
            } else{
                i += 1;
            }
        }

        return result;
    }
}
