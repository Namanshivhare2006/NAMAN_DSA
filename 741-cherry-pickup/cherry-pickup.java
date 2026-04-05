class Solution {
    private Integer[][][][] dp;

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[m][n][m][n];

        int ans = solve(0, 0, 0, 0, grid, m, n);
        return Math.max(0, ans); // agar possible nahi to 0
    }

    public int solve(int i1, int j1, int i2, int j2, int[][] grid, int m, int n) {

        // invalid cases
        if (i1 >= m || j1 >= n || i2 >= m || j2 >= n ||
            grid[i1][j1] == -1 || grid[i2][j2] == -1) {
            return Integer.MIN_VALUE;
        }

        // destination reached
        if (i1 == m - 1 && j1 == n - 1) {
            return grid[i1][j1];
        }

        if (dp[i1][j1][i2][j2] != null) {
            return dp[i1][j1][i2][j2];
        }

        int cherry = 0;

        // same cell
        if (i1 == i2 && j1 == j2) {
            cherry += grid[i1][j1];
        } else {
            cherry += grid[i1][j1] + grid[i2][j2];
        }

        // 4 possibilities
        int dd = solve(i1 + 1, j1, i2 + 1, j2, grid, m, n);
        int dr = solve(i1 + 1, j1, i2, j2 + 1, grid, m, n);
        int rd = solve(i1, j1 + 1, i2 + 1, j2, grid, m, n);
        int rr = solve(i1, j1 + 1, i2, j2 + 1, grid, m, n);

        int max = Math.max(Math.max(dd, dr), Math.max(rd, rr));

        if (max == Integer.MIN_VALUE) {
            return dp[i1][j1][i2][j2] = Integer.MIN_VALUE;
        }

        return dp[i1][j1][i2][j2] = cherry + max;
    }
}