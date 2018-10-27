package Facebook;

public class LC_33_Search_Rotated_Array {
    public int search(int[] nums, int target) {
        // Edge case
        if (nums == null || nums.length == 0) return 0;
        // Others
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            /**
             * Other case, 1. identify ascending range, then decide if target falls onto that range
             */
            if (nums[mid] < nums[hi]) {
                if (nums[mid] < target && target < nums[hi]) {
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
            else if (nums[mid] > nums[lo]) {
                if (nums[lo] < target && target < nums[mid]) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }
        }
        if (nums[lo] == target) return lo;
        if (nums[hi] == target) return hi;
        return -1;
    }

    public static void main(String[] args) {
        LC_33_Search_Rotated_Array lc = new LC_33_Search_Rotated_Array();
        int[] arr = new int[] {7,8,9,1,2,3,4,5,6};
        lc.search(arr, 1);
    }
}
