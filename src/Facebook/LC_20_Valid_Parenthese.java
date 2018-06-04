package Facebook;

import java.util.Stack;

public class LC_20_Valid_Parenthese {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.push(')');
            }
            else if (c == '{') {
                stack.push('}');
            }
            else if (c == '[') {
                stack.push(']');
            }
            else {
                if (stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
