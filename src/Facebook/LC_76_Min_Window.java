package Facebook;

public class LC_76_Min_Window {
    /**
     * The idea is to find the window that contains all characters first, and then update the left pointer until not enough chars left
     * @param s source
     * @param t target
     * @return size of window
     */
    public String minWindow(String s, String t) {
        // Edge
        if (s == null || s.length() < t.length()) return null;
        // Count of target num
        int[] cntT = new int[256];
        int numT = 0;
        for (char c : t.toCharArray()) {
            cntT[c] += 1;
            if (cntT[c] == 1) numT += 1;
        }
        // Iterate s string
        int numS = 0;
        int[] cntS = new int[256];
        char[] chars = s.toCharArray();
        int ret = Integer.MAX_VALUE;
        String retString = "";

        // Two pointers
        for (int i = 0, j = 0; j < s.length(); j++) {
            cntS[chars[j]] += 1;
            if (cntS[chars[j]] == cntT[chars[j]]) {
                numS += 1;
            }
            // If window find, move left pointer to its maximum
            while (numS >= numT) {
                // update ans
                if (ret > j - i + 1) {
                    ret = j - i + 1;
                }
                // Update numS
                if (cntS[chars[i]] == cntT[chars[i]]) {
                    numS -= 1;
                    retString = s.substring(i, j + 1);
                }
                // Move left pointer, update cntS array values
                cntS[chars[i]] -= 1;
                i += 1;
            }
        }

        return retString;
    }
}
