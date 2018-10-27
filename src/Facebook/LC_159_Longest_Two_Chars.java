package Facebook;

import java.util.HashMap;
import java.util.Map;

public class LC_159_Longest_Two_Chars {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Edge
        if (s == null || s.length() == 0) return 0;
        // Init
        Map<Character, Integer> countMap = new HashMap<>();
        int count = countMap.size();

        // Loop
        int lo = 0, hi = 0;
        int retLength = 0;
        while (hi < s.length()) {
            char top = s.charAt(hi);
            countMap.put(top, countMap.getOrDefault(top, 0) + 1);
            if (countMap.get(top) == 1) {
                count += 1;
            }
            while (count > 2) {
                char curr = s.charAt(lo);
                countMap.put(curr, countMap.get(curr) - 1);
                if (countMap.get(curr) == 0) {
                    count -= 1;
                }
                lo += 1;
            }
            retLength = Math.max(retLength, hi - lo + 1);
            hi += 1;
        }

        return retLength;
    }

    public static void main(String[] args) {
        LC_159_Longest_Two_Chars lc = new LC_159_Longest_Two_Chars();
        System.out.println(lc.lengthOfLongestSubstringTwoDistinct("ecedf"));
    }

}
