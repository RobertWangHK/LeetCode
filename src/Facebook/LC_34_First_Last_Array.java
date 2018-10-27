package Facebook;

public class LC_34_First_Last_Array {

    public int[] searchRange(int[] nums, int target) {

        // Edge
        if (nums == null || nums.length == 0) return new int[0];
        // Init
        int[] ret = new int[2];

        // Find min
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            }
            else if (nums[mid] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }

        if (nums[lo] == target) {
            ret[0] = lo;
        }
        else {
            ret[0] = -1;
        }

        lo = 0;
        hi = nums.length - 1;
        while (lo  + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            }
            else if (nums[mid] < target) {
                lo = mid + 1;
            }
            else {
                lo = mid;
            }
        }

        if (nums[hi] == target) {
            ret[1] = hi;
        }
        else if (nums[lo] == target){
            ret[1] = lo;
        }
        else {
            ret[1] = -1;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5,7,7,8,8,10};
        LC_34_First_Last_Array lc = new LC_34_First_Last_Array();
        System.out.println(lc.searchRange(arr, 6));
    }

}
