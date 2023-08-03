//Number of Distinct Islands
//primeum in leetcode solve in gfg

class Solution {
    public void dfs(int row, int col, int[][] grid, boolean[][] visited, StringBuilder shape, int startRow, int startCol, int n, int m) {
        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        
        visited[row][col] = true;
        shape.append("(" + (row - startRow) + "," + (col - startCol) + ")");
        
        dfs(row + 1, col, grid, visited, shape, startRow, startCol, n, m);
        dfs(row - 1, col, grid, visited, shape, startRow, startCol, n, m);
        dfs(row, col + 1, grid, visited, shape, startRow, startCol, n, m);
        dfs(row, col - 1, grid, visited, shape, startRow, startCol, n, m);
    }
    
    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Set<String> distinctShapes = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    StringBuilder shape = new StringBuilder();
                    dfs(i, j, grid, visited, shape, i, j, n, m);
                    distinctShapes.add(shape.toString());
                }
            }
        }
        
        return distinctShapes.size();
    }
}
