package Facebook;

public class LC_674_Longest_Continuous_Increasing_Sub {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int retLength = 1;
        int maxLength = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                maxLength += 1;
            }
            else {
                // If increase ends
                retLength = Math.max(retLength, maxLength);
                maxLength = 1;
            }
        }

        return Math.max(retLength, maxLength);
    }
}
