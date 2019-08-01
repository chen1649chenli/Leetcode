public class _005LongestPalindromicSubstring {
    int lo, maxLen;

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int len = s.length();
        for (int i = 0; i < len - 1; i += 1){
            expand(s, i, i);
            expand(s, i, i + 1);
        }

        return s.substring(lo, lo + maxLen);

    }

    private void expand(String s, int i, int j){
        while( i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i -= 1;
            j += 1;
        }
        if (j - i - 1 > maxLen){
            maxLen = j - i  -1;
            lo = i + 1;
        }
    }
}
