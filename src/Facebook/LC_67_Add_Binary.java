package Facebook;

public class LC_67_Add_Binary {
    public String addBinary(String a, String b) {

        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();

        StringBuilder sb = new StringBuilder();
        int index1 = chars1.length - 1;
        int index2 = chars2.length - 1;
        int carry = 0;
        int val1 = 0;
        int val2 = 0;

        while (index1  >= 0 || index2 >= 0) {
            val1 = index1 >= 0 ? (chars1[index1] - '0') : 0;
            val2 = index2 >= 0 ? (chars2[index2] - '0') : 0;
            sb.append((val1 + val2 + carry) % 2);
            carry = (val1 + val2 + carry) / 2;
            index1 -= 1;
            index2 -= 1;
        }

        sb.append(carry > 0 ? carry : "");
        return sb.reverse().toString();
    }

}
