import java.util.ArrayList;
import java.util.List;

public class _1002FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<char[]> data = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        if (A == null || A.length == 0) return ans;
        int size = A.length;

        for (String str: A){
            data.add(str.toCharArray());
        }
        char[] chars = A[0].toCharArray();
        for(char c: chars){
            int count = 0;
            for (char[] arr_: data){
                for (int i = 0; i < arr_.length;i++){
                    if (arr_[i] == c){
                        count++;
                        arr_[i] = '$';
                        break;
                    }
                }
            }
            if (count == size){
                ans.add(String.valueOf(c));
            }
        }
        return ans;
    }
}
