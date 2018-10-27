package Facebook;

public class LC_301_Remove_Invalid_Parentheses {
    public String removeInvalidParentheses_Simplified(String s) {
        return "";
    }

    private String helper(String s, char left, char right) {
        int cnt = 0;
        for (int i  = 0; i < s.length(); i++) {
            if (s.charAt(i) == left) cnt += 1;
            else {
                if (cnt > 0) cnt -= 1;
                else s = s.substring(0, i) + s.substring(i + 1);
            }
        }
        return s;
    }
}
