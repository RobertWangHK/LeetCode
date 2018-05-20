package Facebook;

/**
 * Calculate the distance between 2 ints
 */
public class LC_461_Hamming_Distance {
    public int hammingDistance(int x, int y) {
        int ret = 0;
        int num = x ^ y;

        // 1. count the number of 1 in the number
        while (num > 0) {
            ret += (num & 1);
            num = num >> 1;
        }

        // 2. not looping all times, only focus on the 1s of num
        while (num > 0) {
            ret += 1;
            // remove the right most 1 from the number
            num = num & (num - 1);
        }

        return ret;
    }
}
