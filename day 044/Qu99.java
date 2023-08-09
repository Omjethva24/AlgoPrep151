//Unique BST's


class Solution
{
    //Function to return the total number of possible unique BST.
    static int numTrees(int N)
    {
        // Your code goes here
        if (N == 0) {
            return 1;
        }

        int MOD = (int) 1e9 + 7;
        long[] dp = new long[N + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (dp[i] + (dp[j] * dp[i - j - 1])) % MOD;
            }
        }

        return (int)dp[N] % MOD;
        
        
    }
}

