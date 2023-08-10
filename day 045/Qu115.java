//Count distinct pallindromic subsequence

class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        
        long[][] dp = new long[n][n];
        long mod = 1000000007;
        
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] * 2;
                    
                    int left = i + 1, right = j - 1;
                    while (left <= right && chars[left] != chars[i]) {
                        left++;
                    }
                    
                    while (left <= right && chars[right] != chars[i]) {
                        right--;
                    }
                    
                    if (left > right) {
                        dp[i][j] += 2; 
                    } else if (left == right) {
                        dp[i][j] += 1;
                    } else {
                        dp[i][j] -= dp[left + 1][right - 1];
                    }
                }
                
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        
        return (int) dp[0][n - 1];
    }
}
