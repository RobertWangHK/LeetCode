package Facebook;

public class LC_121_Best_Time_BuySell_1 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int maxProfit = 0;
        int minValue = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
            minValue = Math.min(minValue, prices[i]);
        }

        return maxProfit;
    }
}
