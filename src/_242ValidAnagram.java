import java.util.Arrays;

public class _242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] s_ = s.toCharArray();
        char[] t_ = t.toCharArray();
        Arrays.sort(s_);
        Arrays.sort(t_);
        s = new String(s_);
        t = new String(t_);
        return s.equals(t);
    }
}
