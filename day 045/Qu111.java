//Optimal BST

class Solution
{
    public int optimalSearchTree(int keys[], int freq[], int n) {
        int[][] dp = new int[n][n];

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j=g; j < n; i++, j++) {
                
                if(g==0){
                    dp[i][j] = freq[i];
                }else if(g==1){
                    int f1 = freq[i];
                    int f2 = freq[j];
                    dp[i][j] = Math.min(f1 + 2 * f2, f2 + 2 * f1);
                }else{
                    int min = Integer.MAX_VALUE;
                    int fs = 0;
                    
                    for(int x=i; x<=j; x++){
                        fs += freq[x];
                    }
                    
                    for(int k=i; k<=j; k++){
                        int left = k==i?0:dp[i][k-1];
                        int right = k==j?0:dp[k+1][j];
                        
                        if(left + right + fs < min){
                            min = left + right + fs;
                        }
                    }
                    dp[i][j]=min;
                }
            }
        }
        return dp[0][n - 1];
    }
}

