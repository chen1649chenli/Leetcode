import java.util.ArrayList;
import java.util.List;

public class _1002FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        if (A == null || A.length == 0) return ans;
        int[] count = new int[26];

        for (int i = 0; i < A[0].length(); i++){
            count[A[0].charAt(i) - 'a']++;
        }

        for (int i = 1; i < A.length; i++){
            int[] tmpCount = new int[26];
            for (int j = 0; j < A[i].length(); j++){
                tmpCount[A[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++){
                count[j] = Math.min(count[j], tmpCount[j]);
            }
        }
        for (int i = 0; i < 26; i++){
            for (int j = 0; j < count[i]; j++){
                ans.add(Character.toString((char) (i + 'a')));
            }
        }
        return ans;
    }
}
