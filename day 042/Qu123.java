//0-1 Knapsack

class Solution 
{ 
    static int knapSackUtil(int wt[], int val[], int dp[][], int w, int n){
        if(w==0 || n==0){
            return 0;
        }
        
        if(dp[n][w]!=-1){
            return dp[n][w];
        }
        //valid
        if(wt[n-1] <= w){
            int ans1 = val[n-1] + knapSackUtil(wt, val, dp, w-wt[n-1], n-1);
            int ans2 = knapSackUtil(wt, val, dp, w, n-1);
            
            dp[n][w] =  Math.max(ans1, ans2);
            return dp[n][w];
        }else{
            dp[n][w] = knapSackUtil(wt, val, dp, w, n-1);
            return dp[n][w];
        }
    } 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here
         int dp[][] = new int[n+1][W+1];
         
         for(int i=0; i<dp.length; i++){
             Arrays.fill(dp[i], -1);
         }
         
         return knapSackUtil(wt, val, dp, W, n);
    } 
}