import java.util.HashSet;
import java.util.Set;

public class _929UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {

        Set<String> list = new HashSet<>();
        int size = emails.length;
        for (int i = 0; i < size; i += 1){
            String email = emails[i];
            int _at = email.indexOf('@');
            String local = email.substring(0, _at);
            int _plus = local.indexOf('+');
            if (_plus != -1){
                local = local.substring(0, _plus);
            }
            local = local.replaceAll("\\.", "");
            email = local + email.substring(_at);
            list.add(email);
        }
        return list.size();
    }
}
