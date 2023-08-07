// /Coin change permutation

class Solution {
    public int change(int amount, int[] coins) {
        int N = coins.length;
        int dp[][] = new int[N+1][amount+1];
         
         for(int i=0; i<dp.length; i++){
             dp[i][0] = 1;
         }
         
         for(int i=1; i<dp[0].length; i++){
             dp[0][i] = 0;
         }
         
         for(int i=1; i<N+1; i++){
             for(int j=1; j<amount+1; j++){
                 if(coins[i-1]<=j){
                     dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                 }
                 else{
                     dp[i][j] = dp[i-1][j];
                 }
             }
         }
         return dp[N][amount];
    }
}
