public class Amazon_StringCompress {
    public String compress(char[] s){
        if (s == null || s.length == 0) return null;
        int ans = 0, i = 0;
        while(i < s.length){
            char c = s[i];
            int count = 0;
            while(i < s.length && c == s[i]){
                count += 1;
                i += 1;
            }
            if(count > 1){
                for (char x : Integer.toString(count).toCharArray()){
                    s[ans++] = x;
                }
                s[ans++] = c;
            }else{
                s[ans++] = c;
            }
        }
        String tmp = new String(s);
        return tmp.substring(0, ans);
    }
}
