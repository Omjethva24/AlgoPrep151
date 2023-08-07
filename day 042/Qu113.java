//Longest Common Subsequence

class Solution {
    public int longestCommonSubsequenceUtil(String text1, String text2, int n, int m,
     int dp[][]){
         if(n==0 || m==0){
             return 0;
         }

         if(dp[n][m]!=-1){
             return dp[n][m];
         }

         if(text1.charAt(n-1)==text2.charAt(m-1)){
             dp[n][m] = longestCommonSubsequenceUtil(text1, text2, n-1, m-1, dp)+1;
             return dp[n][m];
         }else{
             dp[n][m] = Math.max(longestCommonSubsequenceUtil(text1, text2, n-1, m, dp),
             longestCommonSubsequenceUtil(text1, text2, n, m-1, dp));
             return dp[n][m];
         }
    }       
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i], -1);
        }
        return longestCommonSubsequenceUtil(text1, text2, n, m, dp);
    }
}