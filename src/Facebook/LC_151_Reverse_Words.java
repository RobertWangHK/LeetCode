package Facebook;

public class LC_151_Reverse_Words {
    public String reverseWords(String s) {
        // Edge
        if (s == null || s.length() == 0) return "";
        // Init
        s = s.trim();
        char[] chars = s.toCharArray();

        // Reverse whole string
        reverse(chars, 0, chars.length - 1);

        // Reverse each words
        int startIndex = 0, endIndex = 0;
        while (endIndex < chars.length) {

            if (chars[endIndex] != ' ') {
                endIndex += 1;
            }
            else {
                // chars[endIndex] == ' '
                reverse(chars, startIndex, endIndex - 1);
                // Find start of next word
                while (chars[endIndex] == ' ') {
                    endIndex += 1;
                }
                startIndex = endIndex;
            }
        }

        reverse(chars, startIndex, endIndex - 1);

        // Remove too many empty spaces
        int lastIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[lastIndex++] = chars[i];
            }
            // Empty spaces
            else {
                while (chars[i] == ' ') {
                    i += 1;
                }
                chars[lastIndex++] = ' ';
                i -= 1;
            }
        }

        // Rebuild String
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lastIndex; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    private void reverse(char[] chars, int lo, int hi) {
        int i = lo, j = hi;
        while (i < j) {
            exch(chars, i, j);
            i++;
            j--;
        }
    }

    private void exch(char[] chars, int lo, int hi) {
        char tmp = chars[lo];
        chars[lo] = chars[hi];
        chars[hi] = tmp;
    }

    public static void main(String[] args) {
        LC_151_Reverse_Words lc = new LC_151_Reverse_Words();
        System.out.println(lc.reverseWords(" the sky is blue "));
    }
}
