//Matrix Chain Multiplication

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int dp[][] = new int[N][N];
        
        for(int a[] : dp){
            Arrays.fill(a, -1);
        }
        
        return findMinCost(arr, 1, N-1, dp);
    }
    
    static int findMinCost(int arr[], int i, int j, int dp[][]){
        //base case
        if(i == j){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int k=i; k<=j-1; k++){
            int cost1 = findMinCost(arr, i, k, dp);
            int cost2 = findMinCost(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        
        dp[i][j] = ans;
        return ans;
    }
}
