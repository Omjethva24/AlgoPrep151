//unbounded knapsack

class Solution{
     
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int dp[][] = new int[N+1][W+1];
         
         for(int i=0; i<dp.length; i++){
             dp[i][0] = 0;
         }
         
         for(int i=0; i<dp[0].length; i++){
             dp[0][i] = 0;
         }
         
         for(int i=1; i<dp.length; i++){
             for(int j=1; j<dp[0].length; j++){
                 int v=val[i-1];
                 int w=wt[i-1];
                 if(w<=j){
                     dp[i][j] = Math.max(v+dp[i][j-w], dp[i-1][j]);
                 }
                 else{
                     dp[i][j] = dp[i-1][j];
                 }
             }
         }
         return dp[N][W];
    }
}
