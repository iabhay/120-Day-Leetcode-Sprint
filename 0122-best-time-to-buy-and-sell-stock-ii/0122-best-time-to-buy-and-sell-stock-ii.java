

public class Solution {
    public int maxProfit(int[] prices) {
       int length = prices.length;
		if (length < 2) {
			return 0;
		}
		int profit = 0;
		int lastBuy = prices[0];
		for (int i = 1; i < length; i++) {
			if (prices[i]>lastBuy) {
				profit = prices[i] - lastBuy + profit;
			}
			lastBuy = prices[i];
		}
		return profit;
    }
}