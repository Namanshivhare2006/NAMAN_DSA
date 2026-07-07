class Solution {
    private static final int MOD = 1_000_000_007;
    private int ans = 0;

    private int memo(int n, int m, int[][] grid, int[][] dp, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int count = 0;

        // Down
        if (i + 1 < n && grid[i + 1][j] > grid[i][j]) {
            count = (count + 1 + memo(n, m, grid, dp, i + 1, j)) % MOD;
        }

        // Up
        if (i - 1 >= 0 && grid[i - 1][j] > grid[i][j]) {
            count = (count + 1 + memo(n, m, grid, dp, i - 1, j)) % MOD;
        }

        // Right
        if (j + 1 < m && grid[i][j + 1] > grid[i][j]) {
            count = (count + 1 + memo(n, m, grid, dp, i, j + 1)) % MOD;
        }

        // Left
        if (j - 1 >= 0 && grid[i][j - 1] > grid[i][j]) {
            count = (count + 1 + memo(n, m, grid, dp, i, j - 1)) % MOD;
        }

        return dp[i][j] = count;
    }

    public int countPaths(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = (ans + 1) % MOD;
                if (dp[i][j] == -1) {
                    int current = memo(n, m, grid, dp, i, j);
                    ans = (ans + current) % MOD;
                } else {
                    ans = (ans + dp[i][j]) % MOD;
                }
            }
        }

        return ans;
    }
}