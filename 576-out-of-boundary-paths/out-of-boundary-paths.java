// class Solution {
//     public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//         return maxcount(startRow, startColumn, maxMove, m, n);
//     }

//     public static int maxcount(int i, int j, int maxMove, int m, int n) {

//         if (i < 0 || i >= m || j < 0 || j >= n) {
//             return 1;
//         }

//         if (maxMove == 0) {
//             return 0;
//         }

//         return maxcount(i + 1, j, maxMove - 1, m, n) +
//                maxcount(i - 1, j, maxMove - 1, m, n) +
//                maxcount(i, j + 1, maxMove - 1, m, n) +
//                maxcount(i, j - 1, maxMove - 1, m, n);
//     }
// }

class Solution {
    int[][][] dp = new int[52][52][52];
    int MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        // initialize dp with -1
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                for (int k = 0; k < 52; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return maxcount(startRow, startColumn, maxMove, m, n);
    }

    public int maxcount(int i, int j, int maxMove, int m, int n) {

        // out of boundary
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }

        // no moves left
        if (maxMove == 0) {
            return 0;
        }

        // memoization check
        if (dp[i][j][maxMove] != -1) {
            return dp[i][j][maxMove];
        }

        int res = 0;

        res = (res + maxcount(i + 1, j, maxMove - 1, m, n)) % MOD;
        res = (res + maxcount(i - 1, j, maxMove - 1, m, n)) % MOD;
        res = (res + maxcount(i, j + 1, maxMove - 1, m, n)) % MOD;
        res = (res + maxcount(i, j - 1, maxMove - 1, m, n)) % MOD;

        return dp[i][j][maxMove] = res;
    }
}