//Count All Palindromic Subsequence in a given String

class Solution
{
     int countPSUtil(int i, int j, String s, int dp[][]) {
    if (i > j)
        return 0;

    if (i == j) {
        return 1;
    }

    if (dp[i][j] != -1) {
        return dp[i][j];
    }

    if (s.charAt(i) == s.charAt(j)) {
        dp[i][j] = countPSUtil(i + 1, j, s, dp) + countPSUtil(i, j - 1, s, dp) + 1;
    } else {
        dp[i][j] = countPSUtil(i + 1, j, s, dp) + countPSUtil(i, j - 1, s, dp) - countPSUtil(i + 1, j - 1, s, dp);
    }

    return dp[i][j];
}

    long countPS(String str)
    {
        // Your code here
        int n= str.length();
        int dp[][] = new int[n][n];
        
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        
        return countPSUtil(0, n-1, str, dp);
    }
}
