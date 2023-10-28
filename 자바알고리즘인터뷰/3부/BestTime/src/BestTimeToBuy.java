public class BestTimeToBuy {

    public static void main(String[] args) {

        int[] prices = {8, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        int maxP = 0;
        int minPrice = prices[0];

        for (int price: prices) {
            minPrice = Math.min(minPrice, price);
            maxP = Math.max(maxP, price - minPrice);
        }

        return maxP;
    }
}
