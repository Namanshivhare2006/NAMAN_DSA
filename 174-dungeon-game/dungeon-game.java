// class Solution {
//     public int calculateMinimumHP(int[][] dungeon) {

//         int m = dungeon.length;
//         int n = dungeon[0].length;

//         int[][] dp = new int[m + 1][n + 1];

//         int INF = Integer.MAX_VALUE;

//         // Initialize with INF
//         for (int i = 0; i <= m; i++) {
//             for (int j = 0; j <= n; j++) {
//                 dp[i][j] = INF;
//             }
//         }

//         // Base conditions
//         dp[m][n - 1] = 1;
//         dp[m - 1][n] = 1;

//         // Fill DP table bottom-up
//         for (int i = m - 1; i >= 0; i--) {
//             for (int j = n - 1; j >= 0; j--) {

//                 int need = Math.min(dp[i + 1][j], dp[i][j + 1]) 
//                            - dungeon[i][j];

//                 dp[i][j] = Math.max(1, need);
//             }
//         }

//         return dp[0][0];
//     }
// }
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] cache = new int[dungeon.length][dungeon[0].length];
        for (int[] c : cache) {
            Arrays.fill(c, -1);
        }
        return calculateMinimumHP(dungeon, 0, 0, cache);
    }

    private int calculateMinimumHP(int[][] dungeon, int i, int j, int[][] cache) {
        if (i >= dungeon.length || j >= dungeon[i].length) {
            return Integer.MAX_VALUE;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        if (i == dungeon.length - 1 && j == dungeon[i].length - 1) {
            return dungeon[i][j] <= 0 ? 1 - dungeon[i][j] : 1;
        }
        int right = calculateMinimumHP(dungeon, i, j + 1, cache);
        int down = calculateMinimumHP(dungeon, i + 1, j, cache);
        int min = Math.min(right, down) - dungeon[i][j];
        return cache[i][j] = Math.max(1, min);
    }
}