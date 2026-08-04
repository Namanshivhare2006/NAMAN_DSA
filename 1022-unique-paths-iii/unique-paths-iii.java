class Solution {

    int m, n;
    int res = 0;
    int nonObstacle = 0;

    public int uniquePathsIII(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0)
                    nonObstacle++;

                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        // Include the starting cell
        nonObstacle++;

        backtrack(grid, 0, startX, startY);

        return res;
    }

    public void backtrack(int[][] grid, int count, int i, int j) {

        // Out of bounds or obstacle/visited
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return;
        }

        // Reached destination
        if (grid[i][j] == 2) {
            if (count == nonObstacle) {
                res++;
            }
            return;
        }

        // Save current value
        int temp = grid[i][j];

        // Mark as visited
        grid[i][j] = -1;

        // Explore all four directions
        backtrack(grid, count + 1, i + 1, j);
        backtrack(grid, count + 1, i - 1, j);
        backtrack(grid, count + 1, i, j + 1);
        backtrack(grid, count + 1, i, j - 1);

        // Backtrack
        grid[i][j] = temp;
    }
}