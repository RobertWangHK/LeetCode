package Facebook;

public class LC_215_Kth_Largest {
    /**
     Apply the partition of quick sort algorithm to partition the array to get element of index (nums.length - k) in a log manner
     Partition: return the breaking point such that all left elements are smaller than pivot element, and all elements on the right hand side are bigger than the pivot element.
     This way, we can quickly approach the index of elements that we are interested in in a log time manner
     e.g. k = 4th, parititon 1st -> 5th, because we know that all elements on its left hand side (0-4) are smaller than th e pivot/partition element, and all elements on the right hand side are bigger than this pivot element (6-end), so we know that the target element has to be on the left hand side.
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int index = partition(nums, lo, hi);
            if (index == k) {
                break;
            }
            else if (index > k) {
                hi = index - 1;
            }
            else {
                lo = index + 1;
            }
        }
        return nums[k];
    }

    // Partition helper function
    private int partition(int[] nums, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        while (i < j) {
            while (i <= hi && nums[lo] > nums[i]) i++;
            while (j > lo && nums[j] > nums[lo]) j--;
            if (i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }


    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
