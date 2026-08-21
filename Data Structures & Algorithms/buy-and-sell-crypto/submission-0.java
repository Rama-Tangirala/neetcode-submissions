class Solution {
    public int maxProfit(int[] prices) {
        int minP = prices[0];
        int maxP = 0;
        for(int right = 0; right < prices.length; right++){
            maxP = Math.max(maxP, prices[right] - minP);
            minP = Math.min(prices[right], minP);
        }
        return maxP;
    }
}
