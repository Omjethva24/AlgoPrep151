//200. Number of Islands


class Solution {
    public void mergeIslands(int i, int j, int n, int m, char[][] grid, boolean vis[][]){
        if(i<0 || i>=n || j<0 || j>= m || grid[i][j]=='0' || vis[i][j]==true){
            return;
        }

        vis[i][j]=true;
        mergeIslands(i-1, j, n, m, grid, vis);
        mergeIslands(i+1, j, n, m, grid, vis);
        mergeIslands(i, j-1, n, m, grid, vis);
        mergeIslands(i, j+1, n, m, grid, vis);
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int islands = 0 ;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    mergeIslands(i, j, n, m, grid, vis);
                    islands++;
                }
            }
        }
        return islands;
    }
}