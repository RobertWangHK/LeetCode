package Facebook;

import java.util.HashMap;
import java.util.Map;

public class LC_13_Roman_Integer {

    static Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null) return 0;
        int retNum = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            if (map.get(chars[i]) < map.get(chars[i + 1])) {
                retNum -= map.get(chars[i]);
            }
            else {
                retNum += map.get(chars[i]);
            }
        }

        retNum += map.get(chars[chars.length - 1]);
        return retNum;
    }
}
