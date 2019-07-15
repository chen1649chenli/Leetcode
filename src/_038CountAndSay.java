public class _038CountAndSay {
    public String countAndSay(int n) {
        if (n == 0) return "-1";
        if (n == 1) return "1";
        String str = "1";

        for (int i = 2; i <= n; i += 1){
            str = build(str);
        }
        return str;
    }

    public String build(String str){
        int size = str.length();
        int index = 0;
        StringBuilder str_ = new StringBuilder();

        while(index < size ){
            int count = 1;
            char currChar = str.charAt(index++);
            while(index < size && currChar == str.charAt(index) ){
                index += 1;
                count += 1;
            }
            str_.append(count);
            str_.append(currChar);
        }
        return str_.toString();
    }
}
