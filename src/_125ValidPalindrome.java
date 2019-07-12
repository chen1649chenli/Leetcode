public class _125ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        int head = 0, tail = s.length() -1;
        char headChar, tailChar;
        while(head < tail){
            headChar = s.charAt(head);
            tailChar = s.charAt(tail);
            if (!Character.isLetterOrDigit(headChar)){
                head += 1;
            }else if(!Character.isLetterOrDigit(tailChar)){
                tail -= 1;
            } else{
                if (Character.toLowerCase(headChar) == Character.toLowerCase(tailChar)){
                    tail -= 1;
                    head += 1;
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
