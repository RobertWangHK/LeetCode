package Facebook;

import java.util.Stack;

public class LC_71_Simplify_Path {
    public String simplifyPath(String path) {
        // Edge case
        if (path == null || path.length() == 0) return null;
        // Others
        Stack<String> stack = new Stack<String>();
        String[] strs = path.split("/");
        for (String str : strs) {
            if (str.equals("") || str.equals(".")) continue;
            if (str.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
                else continue;
            }
            stack.push(str);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            String a = stack.pop();
            System.out.println(a);
            sb.append(a);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        LC_71_Simplify_Path lc = new LC_71_Simplify_Path();
        String str = "/abc/...";
        System.out.println(lc.simplifyPath(str));

    }
}
