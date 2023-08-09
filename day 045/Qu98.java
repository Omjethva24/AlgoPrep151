//Count possible ways to construct buildings

class Solution
{
    public int TotalWays(int N)
    {
        // Code here
        if (N == 1) {
            return 4;
        } 
        int MOD = 1000000007;    
        long[] dpB = new long[N + 1];
        long[] dpS = new long[N + 1];
        
        dpB[1] = dpS[1] = 1;
        
        for (int i = 2; i <= N; i++) {
            dpB[i] = dpS[i - 1];
            dpS[i] = (dpB[i - 1] + dpS[i - 1]) % MOD;
        }
        
        long totalWays = (dpB[N] + dpS[N]) % MOD;
        totalWays = (totalWays * totalWays) % MOD;
        
        return (int) totalWays;
    }
}
