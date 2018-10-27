package Facebook;

import java.util.HashMap;
import java.util.Map;

public class LC_205_Isomorphic_String {
    public boolean isIsomorphic(String s, String t) {
        // Edge
        if (s == null || s.length() == 0) return t.length() == 0;
        if (s.length() != t.length()) return false;
        // Init
        Map<Character, Character> convertMap = new HashMap<>();
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            // If chars1[i] not mapped
            if (!convertMap.containsKey(chars1[i])) {
                // If mapped to value is already occupied
                if (convertMap.containsValue(chars2[i])) {
                    return false;
                }
                convertMap.put(chars1[i], chars2[i]);
            }
            // Already mapped, check if comply to mapping rule
            else {
                if (convertMap.get(chars1[i]) != chars2[i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LC_205_Isomorphic_String lc = new LC_205_Isomorphic_String();
        System.out.println(lc.isIsomorphic("aa", "ab"));
    }
}
