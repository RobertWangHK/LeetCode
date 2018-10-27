package Facebook;

public class Fibonacci {
    public int fibonacci(int n) {
        // 1, 1, 2, 3, 5, 8, 13, 21, 34
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i<= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.fibonacci(9));
    }
}
