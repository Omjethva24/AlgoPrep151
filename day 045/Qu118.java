// egg dropping

class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    int dp[][] = new int[n+1][k+1];
	    
	    for(int i=1; i<=n; i++){
	        for(int j=1; j<=k; j++){
	            if(i==1){
	                dp[i][j] = j;
	            }else if(j==1){
	                dp[i][j] = 1;
	            }else{
	                int min = Integer.MAX_VALUE;
	                for(int mj=j-1, pj = 0; mj>=0; mj--, pj++){
	                    int v1 = dp[i][mj];//if egg is survive
	                    int v2 = dp[i-1][pj];//if egg is break
	                    int val = Math.max(v1, v2);
	                    min = Math.min(min, val);
	                }
	                dp[i][j] = min+1;
	            }
	        }
	    }
	    return dp[n][k];
	}
}