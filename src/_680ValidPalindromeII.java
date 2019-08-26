public class _680ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int l = 0, h = s.length() - 1;
        while(l < h){
            if (s.charAt(l) == s.charAt(h)){
                l++; h--;
            }else{
                boolean res1  = valid(s, l+1, h);
                boolean res2 = valid(s, l, h - 1);
                return res1 || res2;
            }
        }
        return true;
    }

    private boolean valid(String s, int l, int h){
        while(l < h){
            if (s.charAt(l) == s.charAt(h)){
                l++; h--;
            }else{
                return false;
            }
        }
        return true;
    }
}
