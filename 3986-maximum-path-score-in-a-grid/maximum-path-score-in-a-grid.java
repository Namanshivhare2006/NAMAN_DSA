class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j][cost] = max score
        int[][][] dp = new int[m][n][k + 1];

        // initialize with -1 (unreachable)
        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        dp[0][0][0] = 0; // starting point

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int cost = 0; cost <= k; cost++) {
                    if (dp[i][j][cost] == -1) continue;

                    // move right
                    if (j + 1 < n) {
                        int val = grid[i][j + 1];
                        int newCost = cost + (val == 0 ? 0 : 1);
                        if (newCost <= k) {
                            dp[i][j + 1][newCost] = Math.max(
                                dp[i][j + 1][newCost],
                                dp[i][j][cost] + val
                            );
                        }
                    }

                    // move down
                    if (i + 1 < m) {
                        int val = grid[i + 1][j];
                        int newCost = cost + (val == 0 ? 0 : 1);
                        if (newCost <= k) {
                            dp[i + 1][j][newCost] = Math.max(
                                dp[i + 1][j][newCost],
                                dp[i][j][cost] + val
                            );
                        }
                    }
                }
            }
        }

        int ans = -1;

        // find best score at destination within cost k
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[m - 1][n - 1][c]);
        }

        return ans == -1 ? -1 : ans;
    }
}