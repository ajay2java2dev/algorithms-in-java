package dev.puzzles.eopi.easy;

/*
- The stock price problem is a basic problem mentioned in elements of programing interviews in
 java.
- The best stock trade needs to be filtered out where the array given is of the stock on daily
basis.
- The stock can only be sold or bought at the start of the day. Problem is to showcase the max
benefit one could receive by buying and then selling the stock in any of the subsequent days.
 */
public class StockPrice {

	public static float getBestPrice(float[] dailyStockPrices) {
		float minStockPrice = Float.MAX_VALUE;
		float maxProfit = 0.00F;

		for (int i = 0; i < dailyStockPrices.length; i++) {
			maxProfit = Math.max(maxProfit, dailyStockPrices[i] - minStockPrice);
			minStockPrice = Math.min(dailyStockPrices[i], minStockPrice);
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		float[] stockPrices = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250};

		System.out.println("Best price : " + getBestPrice(stockPrices));
	}
}
