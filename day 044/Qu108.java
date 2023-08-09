//Best Time to Buy and Sell Stock III

class Solution {
    public int maxProfit(int[] prices) {
         int n = prices.length;
    if (n <= 1) {
        return 0;
    }

    int[][][] dp = new int[n][3][2];

    for (int i = 0; i < n; i++) {
        for (int k = 2; k >= 1; k--) {
            if (i == 0) {
                dp[i][k][0] = 0;
                dp[i][k][1] = -prices[0];
                continue;
            }

            dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
            dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
        }
    }

    return dp[n - 1][2][0];
    }
}

