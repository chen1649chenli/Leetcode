import java.util.Arrays;
import java.util.Comparator;

public class _937ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int str1Pos = o1.indexOf(' ');
                int str2Pos = o2.indexOf(' ');
                String id1 = o1.substring(0, str1Pos);
                String id2 = o2.substring(0, str2Pos);
                char _1 = o1.charAt(str1Pos + 1);
                char _2 = o2.charAt(str2Pos + 1);
                if (_1 <= '9' && _2 <= '9'){
                    return 0;
                }else if(_1 > '9' && _2 <= '9'){
                    return -1;
                }else if (_1 <= '9' && _2 > '9'){
                    return 1;
                }else{
                    int preCompute = o1.substring(str1Pos + 1).compareTo(o2.substring(str2Pos + 1));
                    if (preCompute == 0) return id1.compareTo(id2);
                    else return preCompute;
                }

            }
        };
        Arrays.sort(logs, myComp);
        return logs;
    }
}
