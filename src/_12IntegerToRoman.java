public class _12IntegerToRoman {
    public String intToRoman(int num) {
        String ans = "";
        while(num != 0){
            if (num >= 1000){
                int cnt = num / 1000;
                num = num % 1000;
                while(cnt > 0){
                    ans = ans + "M";
                    cnt--;
                }
            }else if (num >= 900){
                num = num % 900;
                ans = ans + "CM";
            }else if (num >= 500){
                num = num % 500;
                ans = ans + "D";
            }else if (num >= 400){
                num = num % 400;
                ans = ans + "CD";
            }else if (num >= 100){
                int cnt = num / 100;
                num = num % 100;
                while(cnt > 0){
                    ans = ans + "C";
                    cnt--;
                }
            }else if (num >= 90){
                num = num % 90;
                ans = ans + "XC";
            }else if (num >= 50){
                num = num % 50;
                ans = ans + "L";
            }else if (num >= 40){
                num = num % 40;
                ans = ans + "XL";
            }else if (num >= 10){
                int cnt = num / 10;
                num = num % 10;
                while(cnt > 0){
                    ans = ans + "X";
                    cnt--;
                }
            }else if (num >= 9){
                num = num % 9;
                ans = ans + "IX";
            }else if (num >= 5){
                num = num % 5;
                ans = ans + "V";
            }else if (num >= 4){
                num = num % 4;
                ans = ans + "IV";
            }else{
                while(num > 0){
                    ans = ans + "I";
                    num--;
                }
            }
        }
        return ans;
    }
}
