public class AmazonOA_LongestStringMadeUpOfOnlyVowels {
    public int findLongestVowels(String s){
        int len = s.length();
        int start = 0, end = len - 1;
        while(isVowels(s.charAt(start))){
            start += 1;
        }
        while(isVowels(s.charAt(end))){
            end -= 1;
        }
        int max = 0, count = 0;

        for (int i = start; i <= end; i += 1){
            if (isVowels(s.charAt(i))){
                count += 1;
                max = Math.max(max, count);
            }else{
                count = 0;
            }
        }
        return max + start + len - end - 1;
    }

    private boolean isVowels(char c){
        return c == 'i' || c == 'a' || c == 'i' || c == 'u' || c == 'o' ||c == 'e';
    }
}
