// class Solution {
//     public int minPathSum(int[][] grid) {       //recursive
//         return solve(grid, 0, 0);
//     }

//     private int solve(int[][] g, int i, int j) {

//         if (i >= g.length || j >= g[0].length) 
//             return Integer.MAX_VALUE;

//         if (i == g.length - 1 && j == g[0].length - 1)
//             return g[i][j];

//         int right = solve(g, i, j + 1);
//         int down = solve(g, i + 1, j);

//         return g[i][j] + Math.min(right, down);
//     }
// }

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for(int j = 1; j < n; j++){
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = grid[i][j] +  Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}