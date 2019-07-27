import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _455AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookie, child = 0;
        for (cookie = 0; cookie < s.length; cookie++){
            if (child < g.length && s[cookie] >= g[child]){
                child++;
            }
        }
        return child;
    }
}
