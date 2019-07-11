import java.util.HashSet;
import java.util.Set;

public class _771JewelsAndStone {
    public int numJewelsInStones(String J, String S) {
        Set<Character> collection = new HashSet<>();
        for (int i = 0; i < J.length(); i += 1){
            collection.add(J.charAt(i));
        }
        int count = 0;
        for (int j = 0; j < S.length(); j += 1){
            if (collection.contains(S.charAt(j))){
                count += 1;
            }
        }
        return count;
    }
}
