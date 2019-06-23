package dev.puzzles.eopi.easy;

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
