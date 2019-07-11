import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class _811SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : cpdomains){
            int split = str.indexOf(' ');
            int visit = Integer.valueOf(str.substring(0, split));
            String domain = str.substring(split + 1);
            map.put(domain, map.getOrDefault(domain, 0) + visit);
            for (int j = split; j < str.length(); j += 1){
                if (str.charAt(j) == '.'){
                    String subDomain = str.substring(j+1);
                    map.put(subDomain, map.getOrDefault(subDomain, 0) + visit);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (String str: map.keySet()){
            result.add(map.get(str) + " " + str);
        }

        return result;
    }
}
