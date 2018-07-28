package Facebook;

import java.util.Arrays;

public class LC_673_Num_Longest_Inc_Subsequence {
    public int findNumberOfLIS(int[] nums) {
        // Edge case
        if (nums == null || nums.length == 0) return 0;
        // Other case
        int maxLength = 1;
        int ret = 1;

        int[] lens = new int[nums.length];
        int[] counts = new int[nums.length];

        Arrays.fill(lens, 1);
        Arrays.fill(counts, 1);

        // Iterate
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) continue;
                else if (lens[i] == lens[j] + 1) {
                    // different method of getting the same len of maximum length os increwasing subarray
                    counts[i] += counts[j];
                }
                else if (lens[i] < lens[j] + 1) {
                    // newly discovered method of getting a longer maximum length of increasing subarray
                    counts[i] = counts[j];
                    lens[i] = lens[j] + 1;
                }
            }

            // Update maxLength
            if (maxLength == lens[i]) {
                ret += counts[i];
            }
            else if (maxLength < lens[i]) {
                ret = counts[i];
                maxLength = lens[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LC_673_Num_Longest_Inc_Subsequence lc = new LC_673_Num_Longest_Inc_Subsequence();
        int[] arr = new int[] {1,3,5,4,7};
        lc.findNumberOfLIS(arr);
    }
}
