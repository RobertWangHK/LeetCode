package Facebook;

/**
 * nth count and say is the count and say result of the n-1th string
 */
public class LC_38_Count_Say {
    public String countAndSay(int n) {
        if (n == 0) return "";
        if (n == 1) return "1";

        /**
         * nth count and say is the count and say result of the n-1th string
         */
        String str = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char[] chars = str.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) count++;
            else {
                sb.append(count);
                sb.append(chars[i - 1]);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(chars[chars.length - 1]);
        return sb.toString();
    }
}
