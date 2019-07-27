import java.util.HashMap;
import java.util.Map;

public class _860LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five =0, ten = 0;
        for (int bill : bills){
            if (bill == 5){
                five += 1;
            } else if (bill == 10){
                ten += 1;
                five -= 1;
            }else{
                if (ten > 0){
                    ten -= 1;
                    five -= 1;
                }else{
                    five -= 3;
                }
            }
            if (five < 0) return false;
        }
        return true;
    }
}
