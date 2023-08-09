//Best Time to Buy and Sell Stock IV


class Solution {
    public int maxProfit(int k, int[] prices) {
         int n = prices.length;
    if (n <= 1) {
        return 0;
    }

    int limit = k;
    int[][][] dp = new int[n][limit+1][2];
    for (int i = 0; i < n; i++) {
        for (int j = limit; j >= 1; j--) {
            if (i == 0) {
                dp[i][j][0] = 0;
                dp[i][j][1] = -prices[0];
                continue;
            }

            dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
            dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
        }
    }

    return dp[n - 1][k][0];
    }
}