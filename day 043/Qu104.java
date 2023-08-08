//Best Time to Buy and Sell Stock


class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;
       if(n<=1){
           return 0;
       }

       int minPrice = prices[0];
       int dp[] = new int[n];
       dp[0] = 0;

       for(int i=1; i<n; i++){
           dp[i] = Math.max(dp[i-1], prices[i]-minPrice);
           minPrice = Math.min(prices[i], minPrice);
       }
       
       return dp[n-1];
    }
}