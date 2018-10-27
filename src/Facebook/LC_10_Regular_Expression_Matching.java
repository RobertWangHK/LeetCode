package Facebook;

public class LC_10_Regular_Expression_Matching {

    public boolean isMatch(String s, String p) {
        // Edge
        if (s == null || s.length() == 0) return false;
        // Init
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = false;
                    continue;
                }
                dp[i][j] = false;
                if (p.charAt(j - 1) != '*') {
                    if (i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
                else {
                    if (j >= 2) {
                        dp[i][j] |= dp[i][j - 2];
                    }
                    if (i > 0 && j >= 2 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }

            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        LC_10_Regular_Expression_Matching lc = new LC_10_Regular_Expression_Matching();
        System.out.println(lc.isMatch("", ""));
    }

}
