package Facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC_824_Goat_Latin {
    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) return "";
        String[] strs = S.split(" ");
        StringBuilder sb = new StringBuilder();

        Set<Character> sets = new HashSet<>();
        sets.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < strs.length; i++) {
            String currString = strs[i];
            if (sets.contains(Character.toLowerCase(currString.charAt(0)))) {
                sb.append(currString);
                sb.append("ma");
            }
            else {
                sb.append(currString.substring(1));
                sb.append(currString.charAt(0));
                sb.append("ma");
            }
            for (int j = 0; j <= i; j++) {
                sb.append('a');
            }
            sb.append(" ");
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
