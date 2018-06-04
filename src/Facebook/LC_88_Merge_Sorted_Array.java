package Facebook;

public class LC_88_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return;

        // Normal cases
        int index = nums1.length - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (index1 >= 0  || index1 >= 0) {
            if (index1 < 0) {
                nums1[index--] = nums2[index2--];
            }
            else if (index2 < 0) {
                nums1[index--] = nums1[index1--];
            }
            else {
                if (nums1[index1] >= nums2[index2]) {
                    nums1[index--] = nums1[index1--];
                }
                else {
                    nums1[index--] = nums2[index2--];
                }
            }
        }
    }
}
