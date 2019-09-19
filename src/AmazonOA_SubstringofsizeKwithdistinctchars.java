import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AmazonOA_SubstringofsizeKwithdistinctchars {
    public static List<String> substringK(String s, int k){
        int start = 0;
        int end = 0;
        Set<String> ansSet = new HashSet<>();
        Set<Character> charSet = new HashSet<>();
        while(end < s.length()){
            char c = s.charAt(end);
            if (charSet.contains(c)){
                charSet.remove(s.charAt(start));
                start += 1;
            }
            charSet.add(c);
            if (charSet.size() == k){
                ansSet.add(s.substring(start, end+ 1));
                charSet.remove(s.charAt(start));
                start+= 1;
            }
            end += 1;
        }
        return new ArrayList(ansSet);
    }

    public static void main(String[] args) {
        System.out.println(substringK("abcabc",3));
        System.out.println(substringK("abacab",3));
        System.out.println(substringK("awaglknagawunagwkwagl",4));
        System.out.println(substringK("",4));
        System.out.println(substringK("aba",1));
        System.out.println(substringK("aba",0));
        System.out.println(substringK("abc",-1));
    }
}
