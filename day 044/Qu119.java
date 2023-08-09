//Regular Expression Matching


class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];

        dp[0][0] = true;

        //s is 0
        for(int i=1; i<m+1; i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        //p is 0
        for(int j=1; j<n+1; j++){
                dp[j][0] = false;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                     dp[i][j] = dp[i][j - 2] || ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                } else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}
