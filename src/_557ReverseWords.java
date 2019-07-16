public class _557ReverseWords {
    public String reverseWords(String s) {
        if(s == "" || s == null || s.length() < 1) return s;

        char[] arr =  s.toCharArray();
        int prev = 0, curr = 1;
        while (curr < s.length()){
            if (arr[curr] == ' ' || curr == s.length() - 1){

                int pointer = curr == s.length() -1 ? curr + 1: curr;
                while(prev < pointer){
                    char tmp = arr[prev];
                    arr[prev] = arr[pointer - 1];
                    arr[pointer - 1] = tmp;
                    prev++;
                    pointer--;
                }
                prev = curr + 1;
            }
            curr += 1;
        }
        return new String(arr);
    }
}
