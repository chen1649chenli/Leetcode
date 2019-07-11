import java.util.HashSet;
import java.util.Set;

public class _202HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> map = new HashSet();
        while(map.add(n)){
            n = isHappyHelper(n);
            if (n == 1){
                return true;
            }
        }
        return false;
    }

    public int isHappyHelper(int m){

        int sum = 0;
        while(m > 0){
            int digit = m % 10;
            m = m / 10;
            sum += digit * digit;
        }
        return sum;
    }
}
