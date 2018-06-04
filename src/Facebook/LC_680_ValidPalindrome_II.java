package Facebook;

public class LC_680_ValidPalindrome_II {
    public boolean validPalindrome(String s) {
        return helper(s, 0);
    }

    private boolean helper(String s, int v) {
        if (s == null || s.length() == 0) return true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                if (v == 0) {
                    String s1 = s.substring(0, i) + s.substring(i + 1);
                    String s2 = s.substring(0, j) + s.substring(j + 1);
                    return helper(s1, 1) || helper(s2, 1);
                }
                return false;
            }
        }
        return true;
    }
}
