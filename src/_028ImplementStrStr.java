import java.util.HashMap;
import java.util.Map;

public class _028ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle == "" || needle == null || needle.length() < 1) return 0;
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i <= n - m; i += 1){
            int j;
            for (j = 0; j < m; j += 1){
                if (haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
            }
            if (j == m) return i;
        }
        return -1;
    }
}
