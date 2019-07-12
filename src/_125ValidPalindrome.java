public class _125ValidPalindrome {
    public boolean isPalindrome(String s) {
        String s_ = s.replaceAll("[^a-zA-Z0-9]]","").toLowerCase();
        String t = new StringBuilder(s_).reverse().toString();
        return s_.equals(t);
    }
}
