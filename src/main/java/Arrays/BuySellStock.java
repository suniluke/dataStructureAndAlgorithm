package Arrays;

public class BuySellStock {

    public static void main(String[] args) {
        int[] prices = new int[] {6,5,4,3,2,1};

        int maxProfit = getMaxProfit(prices);
        System.out.println("Max Profit: " + maxProfit);
    }

    private static int getMaxProfit(int[] prices) {

        int minBuyPrice = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for(int i=0; i<prices.length; i++){
            minBuyPrice = Integer.min(minBuyPrice, prices[i]);
            profit = Integer.max(profit, prices[i] - minBuyPrice);
        }
        return profit;
    }
}
