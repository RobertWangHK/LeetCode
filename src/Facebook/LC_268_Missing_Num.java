package Facebook;

public class LC_268_Missing_Num {
    /**
     * Find element of an array:
     * 1. denote inside the array
     * 2. xor : a ^ a = 0
     *
     * So if we construct a xor num that is the result of xor operation of all
     * elements, then xor with element in the array generates the missing one
     *
     * @param nums num array
     * @return missing element
     */
    public int missingNumber(int[] nums) {
        int xorNum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xorNum ^= i;
        }
        for (int num : nums) {
            xorNum ^= num;
        }
        return xorNum;
    }
}
