class Solution {
    Integer[][][] dp;

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new Integer[m][n][n];

        return solve(0, 0, n - 1, grid, m, n);
    }

    public int solve(int i, int j1, int j2, int[][] grid, int m, int n) {

        // out of bounds
        if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n) {
            return Integer.MIN_VALUE;
        }

        // last row
        if (i == m - 1) {
            if (j1 == j2) return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != null) return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;

        // 9 moves (manual)
        max = Math.max(max, solve(i + 1, j1 - 1, j2 - 1, grid, m, n));
        max = Math.max(max, solve(i + 1, j1 - 1, j2,     grid, m, n));
        max = Math.max(max, solve(i + 1, j1 - 1, j2 + 1, grid, m, n));

        max = Math.max(max, solve(i + 1, j1,     j2 - 1, grid, m, n));
        max = Math.max(max, solve(i + 1, j1,     j2,     grid, m, n));
        max = Math.max(max, solve(i + 1, j1,     j2 + 1, grid, m, n));

        max = Math.max(max, solve(i + 1, j1 + 1, j2 - 1, grid, m, n));
        max = Math.max(max, solve(i + 1, j1 + 1, j2,     grid, m, n));
        max = Math.max(max, solve(i + 1, j1 + 1, j2 + 1, grid, m, n));


        if (max == Integer.MIN_VALUE) {
            return dp[i][j1][j2] = Integer.MIN_VALUE;
        }

        int cherries;
        if (j1 == j2) {
            cherries = grid[i][j1];
        } else {
            cherries = grid[i][j1] + grid[i][j2];
        }

        return dp[i][j1][j2] = cherries + max;
    }
}