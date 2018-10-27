package Facebook;

import java.util.TreeMap;

public class LC_862_Shortest_Array_With_Sum_K {

    public int shortestSubarray(int[] A, int K) {
        // Edge
        if (A == null || A.length == 0) return 0;
        // Init
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int sum = 0, retLength = Integer.MAX_VALUE;

        // Loop
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            // Cater for the case where there is no sum - K exists in the array
            if (sum >= K) {
                retLength = Math.min(retLength, i + 1);
            }
            Integer preSum = treeMap.floorKey(sum - K);
            while (preSum != null) {

                retLength = Math.min(retLength, i - treeMap.get(preSum) + 1);

                treeMap.remove(preSum);
                preSum = treeMap.floorKey(sum - K);
            }
            treeMap.put(sum, i);
        }
        return retLength;
    }

    public static void main(String[] args) {
        LC_862_Shortest_Array_With_Sum_K lc = new LC_862_Shortest_Array_With_Sum_K();
        int[] arr = new int[] {2,-1,2};
        System.out.println(lc.shortestSubarray(arr, 3));
    }

}
