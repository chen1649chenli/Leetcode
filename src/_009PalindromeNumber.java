public class _009PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0) return false;
        int y = x, tmp = 0;
        while(y > 0){
            if (tmp > Integer.MAX_VALUE / 10) return false;
            tmp = tmp * 10 + y % 10;
            y = y / 10;
        }
        return x == tmp;
    }
}
