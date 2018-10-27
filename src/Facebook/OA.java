package Facebook;

public class OA {
    public int max(int[] arr) {
        // Edge
        if (arr == null || arr.length == 0) return 0;
        // Init
        int ret = 0;
        int[] dp = new int[arr.length + 1];

        dp[0] = 0;
        dp[1] = arr[0];

        for (int i = 1; i <= arr.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 1]) + arr[i - 1];
            ret = Math.max(ret, dp[i]);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5,9,-1,-3,4,5};
        OA oa = new OA();
        System.out.println(oa.max(arr));
    }
}
