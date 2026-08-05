class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int current = prices[0];
        for(int i = 1 ; i < prices.length; i++) {
            if(current > prices[i]) {
                current = prices[i];
            }
            profit = Math.max(profit, prices[i] - current);
        }
        return profit;
    }
}