//Cherry Pickup

class Solution {
    public int cherryPickupUtil(int r1, int r2, int c1, int c2, int grid[][], int dp[][][][]){
        if(r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length ||
         c2 >= grid[0].length || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }

        if(r1 == grid.length - 1 && c1 == grid[0].length - 1){
            return grid[r1][c1];
        }

        if(dp[r1][c1][r2][c2] != -1){
            return dp[r1][c1][r2][c2];
        }

        int cherries = 0;
        if(r1 == r2 && c1 == c2){
            cherries += grid[r1][c1];
        }else{
            cherries += grid[r1][c1] + grid[r2][c2];
        }

        int f4 = cherryPickupUtil(r1, r2 + 1, c1 + 1, c2, grid, dp);//h - v
        int f3 = cherryPickupUtil(r1 + 1, r2, c1, c2 + 1, grid, dp);//v - h
        int f2 = cherryPickupUtil(r1 + 1, r2 + 1, c1, c2, grid, dp);//v - v
        int f1 = cherryPickupUtil(r1, r2, c1 + 1, c2 + 1, grid, dp);//h - h 

        cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));
        dp[r1][c1][r2][c2] = cherries;
        return cherries;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int dp[][][][] = new int[n][n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
        int result = Math.max(0, cherryPickupUtil(0, 0, 0, 0, grid, dp));
        return result;
    }
}