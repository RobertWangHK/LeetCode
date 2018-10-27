package Facebook;


import java.util.List;
import java.util.ArrayList;

public class LC_658_Find_K_Closest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length-k;

        while(start<end) {
            int mid = (start + end)/2;
            if (x - arr[mid] > arr[mid+k]-x)
                start = mid + 1;
            else
                end = mid;
        }

        List<Integer> results = new ArrayList<Integer>();
        for(int i=start;i<start+k;i++){
            results.add(arr[i]);
        }
        return results;

    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7,8,9};
        LC_658_Find_K_Closest lc = new LC_658_Find_K_Closest();
        System.out.println(lc.findClosestElements(nums, 2, 3));
    }
}
