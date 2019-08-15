import java.util.Stack;

public class _394DecodeString {
    public String decodeString(String s) {
        int size = s.length();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String str = "";
        int idx = 0;
        while (idx < size){
            if (Character.isDigit(s.charAt(idx))){
                int count = 0;
                while(Character.isDigit(s.charAt(idx))){
                    count = count * 10 + s.charAt(idx) - '0';
                    idx++;
                }
                numStack.push(count);
            }else if (s.charAt(idx) == '['){
                strStack.push(str);
                str = "";
                idx++;
            }else if (s.charAt(idx) == ']'){
                int num = numStack.pop();
                StringBuilder strTmp = new StringBuilder(strStack.pop());
                for (int i = 0; i < num; i++ ){
                    strTmp.append(str);
                }
                str = strTmp.toString();
                idx++;
            }else{
                str = str + s.charAt(idx);
                idx++;
            }
        }
        return str;
    }
}
