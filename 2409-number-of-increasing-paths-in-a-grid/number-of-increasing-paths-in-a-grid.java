class Solution {

    int MOD = 1000000007;
    int[][] dp;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int countPaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        long ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + solve(i, j, grid)) % MOD;
            }
        }

        return (int) ans;
    }

    private int solve(int i, int j, int[][] grid) {

        if (dp[i][j] != -1)
            return dp[i][j];

        long ans = 1; // Path consisting of only this cell

        for (int[] d : dir) {

            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 0 && nj >= 0 &&
                ni < grid.length &&
                nj < grid[0].length &&
                grid[ni][nj] > grid[i][j]) {

                ans = (ans + solve(ni, nj, grid)) % MOD;
            }
        }

        return dp[i][j] = (int) ans;
    }
}