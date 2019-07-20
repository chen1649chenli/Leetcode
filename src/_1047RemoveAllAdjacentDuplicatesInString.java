import java.util.Stack;

public class _1047RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        int end = -1;

        for (char c : arr){
            if (end >= 0 && c == arr[end]){
                end -= 1;
            }else{
                arr[++end] = c;
            }
        }
        return String.valueOf(arr, 0 , end+1);
    }
}
