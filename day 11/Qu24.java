//Rat in a Maze Problem

class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
         ArrayList<String> paths = new ArrayList<>();
        backtrack(m, n, 0, 0, "", paths);
        return paths;
    }

    private static void backtrack(int[][] m, int n, int row, int col, String path, ArrayList<String> paths) {
        if (row < 0 || col < 0 || row >= n || col >= n || m[row][col] == 0) {
            return;
        }

        if (row == n - 1 && col == n - 1) {
            paths.add(path);
            return;
        }

        m[row][col] = 0; // Mark current cell as visited

        // Explore all possible directions
        backtrack(m, n, row + 1, col, path + "D", paths);
        backtrack(m, n, row - 1, col, path + "U", paths);
        backtrack(m, n, row, col + 1, path + "R", paths);
        backtrack(m, n, row, col - 1, path + "L", paths);

        m[row][col] = 1; // Reset the current cell as unvisited
    }
}
