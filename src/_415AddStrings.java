public class _415AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder str = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i >=0 || j >= 0){
            int sum = carry;
            if (i >= 0){
                sum += num1.charAt(i) - '0';
                i -= 1;
            }
            if (j >= 0){
                sum += num2.charAt(j) - '0';
                j -= 1;
            }
            carry = sum / 10;
            int digit = sum % 10;
            str.append(digit);
        }
        if (carry > 0){
            str.append(carry);
        }
        return str.reverse().toString();
    }
}
